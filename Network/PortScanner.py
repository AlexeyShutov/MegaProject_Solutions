#######################################################################################
#
#   Program Title: Port Scanner Utility
#   Programmer: Harsha Kuchampudi
#   Date: May 19, 2015
#
#   Description: Enter an IP address or URL and a port range where the program
#   will then attempt to find open ports on the given computer by connecting
#   to each of them. On any successful connections mark the port as open.
#
#######################################################################################
from datetime import datetime
import socket
import sys

# Server to Scan for Ports
server_url = raw_input("Please Enter the URL of the Server You Want to Scan for Ports: ")\
    .replace("https://", "")\
    .replace("http://", "")
server_port_start = int(raw_input("Please Enter the Minimum Port Number to Scan (e.g. 1): "))
server_port_end = int(raw_input("Please Enter the Maximum Port Number to Scan (e.g. 100): "))
server_ip = socket.gethostbyname(server_url)

# Display Banner
print("-" * 80)
print("Scanning IP Address " + server_ip + " ... Please Wait...")
print("-" * 80)
print("")

# Scan Start Time
start_time = datetime.now()
print("Started Time: ")
print(start_time)
print("")

# Scan for Ports
try:

    # For Port in User Desired Range...
    for port in xrange(server_port_start, server_port_end):

        # IPV4 Stream-Based Socket
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

        # Get Result of Connection to Port Attempt
        result = sock.connect_ex((server_ip, port))

        # If Connection Was Successful
        if result == 0:
            print("Port " + str(port) + " --------- [X]".format(port))

        # If Connection Was a Failure
        else:
            print("Port " + str(port) + " --------- [ ]".format(port))

        # Close the Opened Socket
        sock.close()

except socket.gaierror:
    sys.exit('Hostname Resolution Error. Exiting')

except socket.error:
    sys.exit("Could Not Connect to the Server")

# Get the Final Stopping Time
stop_time = datetime.now()

# Calculate the Change in Time
time_taken = stop_time - start_time

# Printing the Elapsed Time
print '\nScanning Completed in: ', time_taken



