#######################################################################################
#
#   Program Title: FTP Upload
#   Programmer: Harsha Kuchampudi
#   Date: May 18, 2015
#
#   Description: A file transfer program which can transfer files back and forth
#   from a remote web sever.
#
#######################################################################################

import ftplib

# FTP Upload Program
def ftp_upload():

    # Get Server Information from User
    host = raw_input("Please Enter Your Server's Host: ")
    username = raw_input("Please Enter the Username For Your Server: ")
    password = raw_input("Please Enter the Password For Your Server: ")
    upload_name = raw_input("Please Enter the Path to the File You Want to Upload: ")

    # FTP Connect
    try:

        # Session Initialization
        session = ftplib.FTP(host, username, password)
        file_to_upload = open(upload_name, 'rb')                    # File to Send
        session.storbinary('STOR ' + upload_name, file_to_upload)   # Send the File
        file_to_upload.close()                                      # Close File and Upload

        # Upload Success Message
        print("Upload Success!")

    # In Case of FTP Upload Failure
    except ftplib.all_errors:

        # Print Error Message
        print("Upload Failed!")

        # Restart FTP Upload Program
        ftp_upload()

# FTP Upload Program Start
ftp_upload()
