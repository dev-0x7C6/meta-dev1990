DESCRIPTION = "Userspace driver for wiiremotes. It works as system service and trigger dbus events."

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit cmake_qt5

SRCREV = "v${PV}"
SRC_URI = "gitsm://github.com/dev-0x7C6/wiimotedev.git;protocol=https;branch=master;user=git"

S = "${WORKDIR}/git"

DEPENDS += "qtbase bluez5"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} daemon io manager"

PACKAGECONFIG[systemd] = "-DINSTALL_SYSTEMD=ON,-DINSTALL_SYSTEMD=OFF,systemd"
PACKAGECONFIG[initrd] = "-DINSTALL_INITDX=ON,-DINSTALL_INITD=OFF"
PACKAGECONFIG[daemon] = "-DBUILD_DAEMON=ON,-DBUILD_DAEMON=OFF"
PACKAGECONFIG[io] =  "-DBUILD_IO=ON,-DBUILD_IO=OFF"
PACKAGECONFIG[manager] =  "-DBUILD_MANAGER=ON,-DBUILD_MANAGER=OFF"

FILES:${PN} += "${libdir}/systemd/system"
