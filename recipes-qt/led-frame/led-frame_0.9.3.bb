LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5

SRCREV = "v${PV}"
SRC_URI = "gitsm://github.com/dev-0x7C6/led-frame.git;protocol=ssh;branch=development;user=git"

S = "${WORKDIR}/git"

DEPENDS = " \
  qtbase \
  qtmultimedia \
  qtserialport \
  qtsvg \
  qtwebsockets \
"
RASPBERRYPI_DEFAULT_PACKAGECONFIG ??= ""
RASPBERRYPI_DEFAULT_PACKAGECONFIG_rpi = "dispmanx"

PACKAGECONFIG ??= " \
  ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)} \
  ${RASPBERRYPI_DEFAULT_PACKAGECONFIG} \
"

PACKAGECONFIG[benchmarks] = "-DBENCHMARKS=ON,-DBENCHMARKS=OFF,googlebenchmark"
PACKAGECONFIG[dispmanx] = "-DSUPPORT_DISPMANX=ON,-DSUPPORT_DISPMANX=OFF,userland"
PACKAGECONFIG[systemd] =  "-DSYSTEMD=ON,-DSYSTEMD=OFF,systemd"
PACKAGECONFIG[tests] = "-DTESTS=ON,-DTESTS=OFF,gtest gmock"
PACKAGECONFIG[x11] =  "-DSUPPORT_X11=ON,-DSUPPORT_X11=OFF,libx11 libxext libxcb"
PACKAGECONFIG[mobile] =  "-DMOBILE=ON,-DMOBILE=OFF,qtquickcontrols2"

FILES_${PN} += "${@bb.utils.contains("DISTRO_FEATURES", "systemd", "/lib/systemd/system/led-frame.service", "" ,d)"

do_install_append() {
  if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
    systemctl --root=${D} enable led-frame.service
  fi
}