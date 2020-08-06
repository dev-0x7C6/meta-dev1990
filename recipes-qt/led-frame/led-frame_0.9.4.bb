LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5

PR = "r2"

SRCREV = "v${PV}"
SRC_URI = " \
  gitsm://github.com/dev-0x7C6/led-frame.git;protocol=https;branch=development;user=git \
  file://${BPN}-usb-only.conf \
"

S = "${WORKDIR}/git"

DEPENDS = " \
  systemd-systemctl-native \
  qtbase \
  qtmultimedia \
  qtserialport \
  qtsvg \
  qtwebsockets \
"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd x11', d)} v4l2 usb-only"

# Led-frame do not support both X11 and dispmanx
PACKAGECONFIG_append_rpi = " dispmanx"
PACKAGECONFIG_remove_rpi = "x11"

PACKAGECONFIG[benchmarks] = "-DBENCHMARKS=ON,-DBENCHMARKS=OFF,googlebenchmark"
PACKAGECONFIG[dispmanx] = "-DSUPPORT_DISPMANX=ON,-DSUPPORT_DISPMANX=OFF,userland"
PACKAGECONFIG[systemd] =  "-DSYSTEMD=ON,-DSYSTEMD=OFF,systemd"
PACKAGECONFIG[tests] = "-DTESTS=ON,-DTESTS=OFF,gtest gmock"
PACKAGECONFIG[x11] =  "-DSUPPORT_X11=ON,-DSUPPORT_X11=OFF,libx11 libxext libxcb"
PACKAGECONFIG[mobile] =  "-DMOBILE=ON,-DMOBILE=OFF,qtquickcontrols2"
PACKAGECONFIG[v4l2] = ",,,gstreamer1.0-plugins-bad gstreamer1.0-plugins-base gstreamer1.0-plugins-good"
PACKAGECONFIG[usb-only] = ""

LED_FRAME_ENABLE_SERVICE ?= "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}"
LED_FRAME_ENABLE_SERVICE_PATH = "${@bb.utils.contains('LED_FRAME_ENABLE_SERVICE', 'true', '/lib/systemd/system/led-frame.service', '', d)}"

FILES_${PN} += "${LED_FRAME_ENABLE_SERVICE_PATH} /etc/${BPN}/serial.conf"

do_install_append() {
  if ${LED_FRAME_ENABLE_SERVICE}; then
    systemctl --root=${D} enable led-frame.service
  fi

  if ${@bb.utils.contains('PACKAGECONFIG', 'usb-only', 'true', 'false', d)}; then
    install -m 755 -d ${D}/etc/${BPN}
    install -m 644 ${WORKDIR}/${BPN}-usb-only.conf ${D}/etc/${BPN}/serial.conf
  fi
}
