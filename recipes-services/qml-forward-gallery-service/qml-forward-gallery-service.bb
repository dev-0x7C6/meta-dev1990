SUMMARY = "qml-forward-gallery autostart service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://qml-forward-gallery.service.in"

inherit allarch features_check systemd wallpapers

REQUIRED_DISTRO_FEATURES = "systemd"

SYSTEMD_SERVICE_${PN} = "qml-forward-gallery.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

FILES_${PN} += "${systemd_unitdir}/system"

do_compile() {
	 sed -e 's/@@WALLPAPERS@@/${KERNEL_IMAGETYPE}/' \
         "${WORKDIR}/qml-forward-gallery.service.in" > "${WORKDIR}/qml-forward-gallery.service"
}

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/qml-forward-gallery.service ${D}${systemd_unitdir}/system/
}
