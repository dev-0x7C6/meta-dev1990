SUMMARY = "Startup demo for qt-kiosk-browser"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit features_check systemd

REQUIRED_DISTRO_FEATURES = "systemd"

DEMO_SERVICE_NAME = "qt-kiosk-browser-demo.service"

SRC_URI = "file://${DEMO_SERVICE_NAME} file://qt-kiosk-browser.conf"

SYSTEMD_SERVICE:${PN} = "${DEMO_SERVICE_NAME}"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

DEPENDS += "demo-user"
RDEPENDS:${PN} += "systemd qt-kiosk-browser demo-user "

FILES:${PN} += "${systemd_unitdir}/system"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}/etc/
	install -m 0644 ${WORKDIR}/${DEMO_SERVICE_NAME} ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/qt-kiosk-browser.conf ${D}/etc/qt-kiosk-browser-google.conf
}
