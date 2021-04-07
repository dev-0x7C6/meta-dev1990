SUMMARY = "bijin-tokei autostart service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://qbijin-tokei.service"
INHIBIT_DEFAULT_DEPS = "1"

inherit systemd allarch

SYSTEMD_SERVICE_${PN} = "qbijin-tokei.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

FILES_${PN} += "${systemd_unitdir}/system"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/qbijin-tokei.service ${D}${systemd_unitdir}/system/
}
