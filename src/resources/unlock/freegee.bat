@ECHO OFF

rem First, we need to push the files.
rem after that, we need to untar it
rem then su -c busybox bash /path/to/script

echo Welcome to the FreeGee Unlock for Sprint
echo.
echo Please exit this script now if you do not 
echo wish to unlock your phone, or if you have
echo downloaded an incorrect version for your phone.
echo.
pause

echo.
echo Killing old adb server ...
.\adb.exe kill-server > nul
.\adb.exe devices > nul
echo.
echo Pushing the archive and busybox ...
.\adb.exe push freegee-sprint.tar /data/local/tmp/
.\adb.exe push busybox /data/local/tmp/busybox
echo.
echo Extracting the archive ...
.\adb.exe shell "cd /data/local/tmp/;chmod 755 busybox;./busybox tar xvf freegee-sprint.tar"
echo.
echo Working ...
echo DO NOT INTERRUPT YOUR PHONE UNTIL THIS PROCESS COMPLETES!
echo Accept the Root Access prompt on your phone if one shows up...
echo.
.\adb.exe shell "su -c 'cd /data/local/tmp/;chmod 755 freegee.sh;./freegee.sh'"
echo.
echo.
echo Pulling your backups from the phone to your PC, for safe keeping.
mkdir backups
.\adb.exe pull /sdcard/freegee .\backups\
echo.
echo Please check the above output to see if your phone has successfully been unlocked.
echo.
echo If you liked this, consider donating to us so we can build out our server farm for Team Codefire!
pause