INHIBIT_DEFAULT_DEPS = "1"
LICENSE = "CLOSED"

ASSETS_NAME ?= "${@d.getVar("PN").split('bijin-assets-')[1]}"
SRC_URI = "https://devwork.space/tokei/${ASSETS_NAME}.tar.gz"

inherit allarch

FILES:${PN} = "${datadir}/bijin-assets/${ASSETS_NAME}"

do_install() {
	install -d ${D}${datadir}/bijin-assets
	cp -rf ${WORKDIR}/${ASSETS_NAME} ${D}${datadir}/bijin-assets/
}
