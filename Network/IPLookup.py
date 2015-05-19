#######################################################################################
#
#   Program Title: IP Lookup
#   Programmer: Harsha Kuchampudi
#   Date: May 19, 2015
#
#   Description: Enter an IP address and find the country that IP is registered in.
#
#######################################################################################

import requests
import json

# Function that Looks Up IP Address
def ip_lookup(ip_lookup):

    # IP JSON Fetch and Parse
    ip_link = "http://www.freegeoip.net/json/%s" % ip_lookup
    ip_lookup_data = requests.get(ip_link).text
    ip_lookup_json = json.loads(ip_lookup_data)

    # Output IP Data
    print("\nIP Address: " + ip_lookup_json['ip'])
    print("Latitude: " + str(ip_lookup_json['latitude']))
    print("Longitude: " + str(ip_lookup_json['longitude']))
    print("\nCountry Name: " + ip_lookup_json['country_name'])
    print("Region Name: " + ip_lookup_json['region_name'])
    print("City Name: " + ip_lookup_json['city'])

# User Interaction Dialogue
user_ip = raw_input("Please Enter the IP Address You Want to Lookup: ")
ip_lookup(user_ip)