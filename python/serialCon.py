import serial
import threading
import requests
import struct
from time import sleep

class SerialConnection:
    def __init__(self):
        # 각 커맨드와 그에 해당하는 URL을 매핑한 이중 배열
        self.commands = [
            [b"\x0A\x03\x00\xCB\x00\x02\xB4\x8E"],  # temperature
            [b"\x0A\x03\x00\xD4\x00\x02\x85\x48"],  # humidity
            [b"\x0A\x03\x00\xDD\x00\x02\x55\x4A"],  # carbon-dioxide
            [b"\x0A\x03\x00\xEC\x00\x02\x04\x85"],  # wind-speed
            [b"\x0A\x03\x00\xF5\x00\x02\xD5\x42"],  # wind-direction
            [b"\x0A\x03\x00\xD7\x00\x02\x75\x48"],  # soil
            [b"\x0A\x03\x00\xFE\x00\x02\xA4\x80"]   # solar-radiation
        ]
        self.float_values = []  # 실수값 데이터를 저장할 리스트

    def manage_serial_communication(self, port_name):
        try:
            port = serial.Serial(port_name, baudrate=9600, timeout=2)

            if port.is_open:
                print("Port is open and ready")

                # 각각의 요청에 대해 시리얼 포트로 데이터를 보내고 응답을 받음
                for command in self.commands:
                    try:
                        # 시리얼 포트로 데이터 전송
                        port.write(command)

                        # 응답 데이터 읽기
                        response_data = port.read(9)  # 9바이트 데이터를 읽음
                        print("Received response:", response_data.hex())

                        rearranged_data = bytearray([response_data[5], response_data[6], response_data[3], response_data[4]])

                        # 16진수 형태로 변환
                        hex_value = rearranged_data.hex()

                        # 부동 소수점으로 해석
                        float_value = struct.unpack('!f', bytes.fromhex(hex_value))[0]

                        # 여기에 값을 축적하여 리스트에 추가
                        self.float_values.append(float_value)
                    except Exception as e:
                        print("Error in inner loop:", e)
                        # 오류가 발생한 경우에는 -1을 리스트에 추가
                        self.float_values.append(-1)

                # 스프링 서버로 실수값 데이터 전송
                response = requests.post("http://localhost:8080/SensorConnection", json={'data': self.float_values})
                print("Data sent to Spring server:", response.text)

                # 작업 완료 후 리소스 닫기
                port.close()
            else:
                print("Error: Port is not open")
        except Exception as e:
            print("Error in manage_serial_communication:", e)

class SerialServer:
    def __init__(self, port_name):
        self.port_name = port_name
        self.serial_connection = SerialConnection()

    def start(self):
        while True:
            try:
                self.serial_connection.manage_serial_communication(self.port_name)
                sleep(10)  # 10 초 대기
            except Exception as e:
                print("Error in SerialServer:", e)

if __name__ == "__main__":
    port_name = "COM1"  # 시리얼 포트 이름에 맞게 수정 (예: "COM1" 또는 "/dev/ttyUSB0")
    serial_server = SerialServer(port_name)
    serial_server.start()
