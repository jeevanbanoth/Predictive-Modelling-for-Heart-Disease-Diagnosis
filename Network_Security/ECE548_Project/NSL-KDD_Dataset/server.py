import http.server
import socketserver
import json
import random

class SHM_WSN_Monitor:
    def __init__(self):
        self.num_features = 20

    def generate_sensor_data(self):
        return [random.random() for _ in range(self.num_features)]

    def process_data(self, data):
        # Simple threshold-based detection
        return 1 if sum(data) > 10 else 0

monitor = SHM_WSN_Monitor()

class RequestHandler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):
        if self.path == '/data':
            self.send_response(200)
            self.send_header('Content-type', 'application/json')
            self.end_headers()
            
            sensor_data = monitor.generate_sensor_data()
            prediction = monitor.process_data(sensor_data)
            
            response = json.dumps({
                'prediction': prediction,
                'data': sensor_data
            })
            self.wfile.write(response.encode())
        else:
            super().do_GET()

if __name__ == "__main__":
    PORT = 8000
    with socketserver.TCPServer(("", PORT), RequestHandler) as httpd:
        print(f"Serving at port {PORT}")
        httpd.serve_forever()