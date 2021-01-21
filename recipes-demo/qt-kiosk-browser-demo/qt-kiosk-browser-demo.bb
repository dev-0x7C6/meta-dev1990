SUMMARY = "Startup demo for qt-kiosk-browser"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

DEMO_SERVICE_NAME = "qt-kiosk-browser-demo.service"

SRC_URI = "file://${DEMO_SERVICE_NAME} file://qt-kiosk-browser.conf"

SYSTEMD_SERVICE_${PN} = "${DEMO_SERVICE_NAME}"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

DEPENDS += "demo-user"
RDEPENDS_${PN} += "systemd qt-kiosk-browser demo-user "

FILES_${PN} += "${systemd_unitdir}/system"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}/etc/
	install -m 0644 ${WORKDIR}/${DEMO_SERVICE_NAME} ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/qt-kiosk-browser.conf ${D}/etc/qt-kiosk-browser-google.conf
}
