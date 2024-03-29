SUMMARY = "qml-forward-gallery autostart service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://qml-forward-gallery.service.in"

inherit allarch features_check systemd wallpapers

REQUIRED_DISTRO_FEATURES = "systemd"

SYSTEMD_SERVICE:${PN} = "qml-forward-gallery.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

FILES:${PN} += "${systemd_unitdir}/system"

QML_FORWARD_GALLERY_DIR ?= "${WALLPAPER_DIR}"
QML_FORWARD_GALLERY_DEFAULTS ?= "--sort --random"
QML_FORWARD_GALLERY_EXTRA ??= ""
QML_FORWARD_GALLERY_PARAMETERS ?= "--directory ${QML_FORWARD_GALLERY_DIR} ${QML_FORWARD_GALLERY_DEFAULTS} ${QML_FORWARD_GALLERY_EXTRA}"

do_compile() {
	 sed -e 's#@@QML_FORWARD_GALLERY_PARAMETERS@@#${QML_FORWARD_GALLERY_PARAMETERS}#' \
         "${WORKDIR}/qml-forward-gallery.service.in" > "${WORKDIR}/qml-forward-gallery.service"
}

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/qml-forward-gallery.service ${D}${systemd_unitdir}/system/
}
