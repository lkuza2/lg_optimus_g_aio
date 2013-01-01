LG Optimus G AIO (GAIO)
================

LG Optimus G AIO (GAIO) tool for Sprint.  Unlock and root your device in seconds on Windows and Linux.

Current Version: 1.50

1.50:
* Fixed root detection bug
* Automate root scripts. You no longer have to press '1' to activate the scripts
* Add confirmation dialog for rooting, unlocking, installing recovery etc.
* Fixed bug where adb server was not killed on application close
* Fixed deleting temporary files on exit
* Added software version check to check if device is supported. ZV9 added to unsupported list at the time
* Updated Bin4y root scripts to v18
* Modified those root scripts to work automatically
* Added JSON library. Example of use, http://gaio.dark-hosting.net/gaio/recovery.json  Allows for dynamic elements in program
* Added recovery installer!  Needs internet connection.  Currently supports TWRP and clockwork
* Added element to check if device bootloader is unlocked
* Add boot restore function!  Restore your boot.img if you flashed a bad kernel.  Requires internetc connection
* Added automatic LG Driver installer.  Requires internet connection
* LG Installer will check if Windows driver is installed, if not, gracefully ask the user to install it.
* Added an update function.  This only checks for an update if you are connected to the internet
* The update is checked on start, once, in the background and only annoys you if you are out of date
* Update Swing GUI threading the correct way, since Swing is not thread safe
* Fixed many graphical errors
* Fixed some exceptions
* Fixed many other random bugs and cleaned up some code

1.00:
* Initial Release
