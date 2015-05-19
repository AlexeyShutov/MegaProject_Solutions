#######################################################################################
#
#   Program Title: Site Checker with Time Scheduling
#   Programmer: Harsha Kuchampudi
#   Date: May 19, 2015
#
#   Description: An application that attempts to connect to a website
#   or server every so many minutes or a given time and check if it is up.
#   If it is down, it will notify you by a notice on screen.
#
#######################################################################################

import urllib2
import datetime
import time
import tkMessageBox

# Module that Checks if the Website is Up
def is_it_up(website_url):

    # Connect to the Website and Get the Connection Status Code
    try:
        website_status = urllib2.urlopen(website_url).getcode()
    except urllib2.URLError:
        tkMessageBox.showinfo("isWebsiteUp", "The Website You Are Monitoring Cannot be Opened!")
        exit(0)
    except ValueError:
        tkMessageBox.showinfo("isWebsiteUp", "Incorrect URL Format, Please Include the http(s)://")
        exit(0)

    # If the Website is Not Up (Code is Not 200), Return False
    if website_status is not 200:
        return False

    # Otherwise Return True
    print("The Website is Up: " + str(datetime.datetime.now()))
    return True

# User Interaction Dialogue
website = raw_input("Please Enter the URL You Wish to Monitor (e.g. http//www.google.com): ")
minutes_interval = float(raw_input("How Frequently do You Want to Check the Site (in Minutes): ")) * 60

# Sleep Loop Check
while is_it_up(website):
    time.sleep(minutes_interval)

# Alert if the Website Goes Down
tkMessageBox.showinfo("isWebsiteUp", "The Website You Are Monitoring Has Gone Down!")
