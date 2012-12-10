echo "Welcome to the FreeGee Unlock for Sprint"

echo "Killing old adb server ..."
./adb kill-server
./adb devices

echo "Pushing the archive and busybox ..."
./adb push freegee-sprint.tar /data/local/tmp/
./adb push busybox /data/local/tmp/busybox
echo "Extracting the archive ..."
./adb shell "cd /data/local/tmp/;chmod 755 busybox;./busybox tar xvf freegee-sprint.tar"
echo "Working ..."
echo "DO NOT INTERRUPT YOUR PHONE UNTIL THIS PROCESS COMPLETES!"
echo "Accept the Root Access prompt on your phone if one shows up..."
./adb shell "su -c 'cd /data/local/tmp/;chmod 755 freegee.sh;./freegee.sh'"
echo "Pulling your backups from the phone to your PC, for safe keeping."
mkdir ~/backups
./adb pull /sdcard/freegee ~/backups/

echo "Please check the above output to see if your phone has successfully been unlocked."
echo "If you liked this, consider donating to us so we can build out our server farm for Team Codefire!"

read -p "Press key to exit ..."
exit 0
