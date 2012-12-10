#!/bin/bash
NXT=0
echo "======================================================================"
echo "= This script will root your Android phone with adb restore function ="
echo "= Script by Bin4ry (thanks to Goroh_kun and tkymgr for the idea)     ="
echo "=                 Idea for Tablet S from Fi01_IS01                   ="
echo "=                         (22.11.2012) v17                           ="
echo "=              ported to Linux by Kamistral (15.09.2012),            ="
echo "=                   updated by codeworkx (01.10.2012)                ="
echo "======================================================================"
echo

choice() {
    echo "Device type:"
    echo "1) Normal"
    echo "2) Special (for example: Sony Tablet S, Medion Lifetab)"
    echo "x) Unroot"
    echo "Make a choice: "
    read type
    case $type in
        1*) echo "Normal mode enabled!"
            do_test
            ;;
        2*) echo "Special mode enabled!"
            tabsmenu
            ;;
        x*) echo "Unroot mode"
            do_unroot
            ;;
        *)  clear
            echo "Please enter a valid command (1, 2, x)"
            choice
            ;;
    esac
}

tabsmenu() {
    echo
    echo "Special mode:"
    echo "1) Root"
    echo "2) Rollback"
    echo "Make a choice:"
    read reply
    case $reply in
        1*) do_root
            ;;
        2*) tablets_rollback
            ;;
        *)  clear
            echo "Please enter a valid number (1 or 2)"
            tabsmenu
            ;;
    esac
}

do_test() {
	RIC=0
    echo "Checking if i should run in Normal Mode or special Sony Mode"
    echo "Please connect device with ADB-Debugging enabled now ..."
    ./stuff/adb wait-for-device
    mkdir -p tmp
	./stuff/adb pull /system/bin/ric tmp/ric
	if [ -e tmp/ric ]; then
		echo "Found RIC-Daemon"
		echo
		RIC=1
		rm tmp/ric
		do_root
	fi
    ./stuff/adb pull /system/app/Backup-Restore.apk tmp/Backup-Restore.apk
    if [ -e tmp/Backup-Restore.apk ]; then
        echo "Found Sony Backup-Restore.apk"
        echo "LT26,LT22 etc. mode enabled!"
        echo
        rm tmp/Backup-Restore.apk
        NXT=1
        do_root
    else
        echo "Normal Mode enabled!"
        do_root
    fi
}

do_root() {
    echo "Please connect device with ADB-Debugging enabled now ..."
    ./stuff/adb wait-for-device
    if [ "$type" == "2" ]; then
        tabtrick
    else
        echo "Pushing busybox ..."
        ./stuff/adb push stuff/busybox /data/local/tmp/.
        echo "Pushing su binary ..."
        ./stuff/adb push stuff/su /data/local/tmp/.
        echo "Pushing Superuser app"
        ./stuff/adb push stuff/Superuser.apk /data/local/tmp/.
		echo "Pushing ric"
		./stuff/adb push stuff/ric /data/local/tmp/ric
        echo "Making busybox runable ..."
        ./stuff/adb shell chmod 755 /data/local/tmp/busybox
        if [ "$RIC" == "1" ]; then
			./stuff/adb push stuff/ric /data/local/tmp/ric
		fi
        if [ "$NXT" == "1" ]; then
            xpstrick
		else
            ./stuff/adb restore stuff/fakebackup.ab
            echo "Please look at your device and click RESTORE!"
            echo "If all is successful i will tell you, if not this shell will run forever."
            echo "Running ..."
            ./stuff/adb shell "while ! ln -s /data/local.prop /data/data/com.android.settings/a/file99; do :; done" > /dev/null
            echo "Successful, going to reboot your device in 10 seconds!"
			ping -n 10 127.0.0.1 > /dev/null
            ./stuff/adb reboot
            echo "Waiting for device to show up again ..."
            ping -n 10 127.0.0.1 > /dev/null
            ./stuff/adb wait-for-device
			do_copy
		fi
    fi
}

do_unroot() {
    echo "Really? (y/n)"
    read reply
    case $reply in
        y*) 
            ./stuff/adb push stuff/busybox /data/local/tmp/busybox
            ./stuff/adb shell "chmod 755 /data/local/tmp/busybox"
            ./stuff/adb shell "su -c '/data/local/tmp/busybox mount -o remount,rw /system'"
            ./stuff/adb shell "su -c 'rm /system/bin/su'"
            ./stuff/adb shell "su -c 'rm /system/app/Superuser.apk'"
            exit 0
            ;;
        n*) 
            clear
            choice
            ;;
        *)  
            clear
            do_unroot
            ;;
    esac
}

do_copy() {
    echo "Copying files to it's place ..."
	if [ "$RIC" == "1" ]; then
		./stuff/adb shell "/data/local/tmp/busybox mount -o remount,rw /system && /data/local/tmp/busybox mv /data/local/tmp/su /system/xbin/su && /data/local/tmp/busybox mv /data/local/tmp/Superuser.apk /system/app/Superuser.apk && /data/local/tmp/busybox cp /data/local/tmp/busybox /system/xbin/busybox && chown 0.0 /system/xbin/su && chmod 06755 /system/xbin/su && chmod 655 /system/app/Superuser.apk && chmod 755 /system/xbin/busybox && rm /data/local.prop && reboot"
	else
		./stuff/adb shell "/data/local/tmp/busybox mount -o remount,rw /system && /data/local/tmp/busybox mv /data/local/tmp/ric /system/bin/ric && chmod 755 /system/bin/ric && /data/local/tmp/busybox mv /data/local/tmp/su /system/xbin/su && /data/local/tmp/busybox mv /data/local/tmp/Superuser.apk /system/app/Superuser.apk && /data/local/tmp/busybox cp /data/local/tmp/busybox /system/xbin/busybox && chown 0.0 /system/xbin/su && chmod 06755 /system/xbin/su && chmod 655 /system/app/Superuser.apk && chmod 755 /system/xbin/busybox && rm /data/local.prop && reboot"
	fi
}

tabtrick() {
    ./stuff/adb install -s stuff/Term.apk
    ./stuff/adb push stuff/busybox /data/local/tmp/.
    ./stuff/adb push stuff/su /data/local/tmp/.
    ./stuff/adb push stuff/Superuser.apk /data/local/tmp/.
    ./stuff/adb push stuff/rootkittablet.tar.gz /data/local/tmp/rootkittablet.tar.gz
    ./stuff/adb shell "chmod 755 /data/local/tmp/busybox"
    ./stuff/adb shell "/data/local/tmp/busybox tar -C /data/local/tmp -x -v -f /data/local/tmp/rootkittablet.tar.gz"
    ./stuff/adb shell "chmod 644 /data/local/tmp/VpnFaker.apk"
    ./stuff/adb shell "touch -t 1346025600 /data/local/tmp/VpnFaker.apk"
    ./stuff/adb shell "chmod 755 /data/local/tmp/_su"
    ./stuff/adb shell "chmod 755 /data/local/tmp/su"
    ./stuff/adb shell "chmod 755 /data/local/tmp/onload.sh"
    ./stuff/adb shell "chmod 755 /data/local/tmp/onload2.sh"
    ./stuff/adb shell "rm -r /data/data/com.android.settings/a/*"
    ./stuff/adb restore stuff/tabletS.ab
    echo "Please look at your device and click \"Restore my data\""
    echo
    ./stuff/adb shell "while [ ! -d /data/data/com.android.settings/a/file99 ] ; do echo 1; done" > /dev/null
    ping -n 3 127.0.0.1 > /dev/null
    echo "1st RESTORE OK"
    read -p "Press [Enter] key to continue ..."
    ./stuff/adb shell "rm -r /data/data/com.android.settings/a"
    ./stuff/adb restore stuff/tabletS.ab
    echo "Please look at your device and click \"Restore my data\""
    echo
    ./stuff/adb shell "while : ; do ln -s /data /data/data/com.android.settings/a/file99; [ -f /data/file99 ] && exit; done" > /dev/null
    ./stuff/adb shell "rm -r /data/file99"
    ping -n 3 127.0.0.1 > /dev/null
    echo "Achieved!"
    read -p "Press [Enter] key to continue ..."
    ./stuff/adb shell "/data/local/tmp/busybox cp -r /data/system /data/system2"
    ./stuff/adb shell "/data/local/tmp/busybox find /data/system2 -type f -exec chmod 666 {} \;"
    ./stuff/adb shell "/data/local/tmp/busybox find /data/system2 -type d -exec chmod 777 {} \;"
    ./stuff/adb shell "mv /data/system /data/system-"
    ./stuff/adb shell "mv /data/system2 /data/system"
    ./stuff/adb shell "mv /data/app /data/app-"
    ./stuff/adb shell "mkdir /data/app"
    ./stuff/adb shell "mv /data/local/tmp/VpnFaker.apk /data/app"
    ./stuff/adb shell "/data/local/tmp/busybox sed -f /data/local/tmp/packages.xml.sed /data/system-/packages.xml > /data/system/packages.xml"
    ./stuff/adb shell "sync; sync; sync"
    echo "Need to reboot now!"
    ./stuff/adb reboot
    ping -n 3 127.0.0.1 > /dev/null
    echo "Waiting for device to come up again ..."
    ./stuff/adb wait-for-device
    echo "Unlock your device, a Terminal will show now, type this 2 lines, after each line press ENTER"
    echo /data/local/tmp/onload.sh
    echo /data/local/tmp/onload2.sh
    echo "after this is done press a key here in this shell to continue!"
    echo "If the shell on your device does not show please re-start the process!"
    ./stuff/adb shell "am start -n com.android.vpndialogs/.Term"
    read -p "Press [Enter] key to continue ..."
    
    # tabtrick1
    ./stuff/adb push stuff/script1.sh /data/local/tmp/.
    ./stuff/adb shell "chmod 755 /data/local/tmp/script1.sh"
    ./stuff/adb shell "/data/local/tmp/script1.sh"
    echo "Almost complete! Reboot and cleanup."
    ./stuff/adb reboot
    ping -n 3 127.0.0.1 > /dev/null
    echo "Waiting for device to come up again ..."
    ./stuff/adb wait-for-device
    ./stuff/adb shell "su -c 'rm -r /data/app2'"
    ./stuff/adb shell "su -c 'rm -r /data/system2'"
    ./stuff/adb shell "su -c 'rm -r /data/local/tmp/*'"
}

tablets_rollback() {
    echo
    echo "Tablet S Rollback"
    echo
    echo "Please connect device with ADB-Debugging enabled now ..."
    ./stuff/adb wait-for-device
    ./stuff/adb shell "if [ -d /data/app- ]; then echo 1 ; else echo 0 ; fi" > reply
    if [ "$reply" == "1" ]; then
        ./stuff/adb shell "rm -r /data/data/com.android.settings/a/*"
        ./stuff/adb restore stuff/tabletS.ab
        echo Please look at your device and click "Restore my data"
        echo.
        ./stuff/adb shell "while [ ! -d /data/data/com.android.settings/a/file99 ] ; do echo 1; done" > /dev/null
        echo "1st RESTORE OK"
        read -p "Press [Enter] key to continue ..."
        ./stuff/adb shell "rm -r /data/data/com.android.settings/a"
        ./stuff/adb restore stuff/tabletS.ab
        echo Please look at your device and click "Restore my data"
        echo.
        ./stuff/adb shell "while : ; do ln -s /data /data/data/com.android.settings/a/file99; [ -f /data/file99 ] && exit; done" > /dev/null
        ./stuff/adb shell "rm -r /data/file99"
        echo "Achieved!"
        read -p "Press [Enter] key to continue ..."
        ./stuff/adb shell "mv /data/system /data/system3"
        ./stuff/adb shell "mv /data/system- /data/system"
        ./stuff/adb shell "mv /data/app /data/app3"
        ./stuff/adb shell "mv /data/app- /data/app"
        echo "Rollback compelted."
    else
        echo "Rollback failed."
        exit 1
    fi
}

xpstrick() {
    NXT=0
    echo "Pushing fake Backup"
    ./stuff/adb push stuff/RootMe.tar /data/local/tmp/RootMe.tar
    ./stuff/adb shell "mkdir /mnt/sdcard/.semc-fullbackup > /dev/null 2>&1"
    echo "Extracting fakebackup on device ..."
    ./stuff/adb shell "cd /mnt/sdcard/.semc-fullbackup/; /data/local/tmp/busybox tar xf /data/local/tmp/RootMe.tar"
    echo "Watch now your device. Select the backup named RootMe and restore it!"
    ./stuff/adb shell "am start com.sonyericsson.vendor.backuprestore/.ui.BackupActivity"
    echo "If all is successful i will tell you, if not this shell will run forever."
    echo "Running ..."
    ./stuff/adb shell "while ! ln -s /data/local.prop /data/data/com.android.settings/a/file99; do :; done" > /dev/null
    echo
    echo "Good, it worked! Now we are rebooting soon, please be patient!"
    ping -n 3 127.0.0.1 > /dev/null
    ./stuff/adb shell "rm -r /mnt/sdcard/.semc-fullbackup/RootMe"
    ./stuff/adb reboot
    ping -n 10 127.0.0.1 > /dev/null
    echo "Waiting for device to come up again ..."
    ./stuff/adb wait-for-device
    do_copy
}

# Main
choice
echo "You can close all open command-prompts now!"
echo "After reboot all is done! Have fun!"
echo "Bin4ry"
read -p "Press key to exit ..."
exit 0
