LICENSE = "CLOSED"

SRC_URI = "https://devwork.space/wallpapers/anime-wallpaper-selection-2021Q2.tar.gz"
S = "${WORKDIR}/anime-wallpaper-selection-2021Q2"

SRC_URI[md5sum] = "ae8d64fea63c962b49f4e6b8277d4fde"
SRC_URI[sha256sum] = "f3e59b4d30a7fa3663e157fdfb8100a1019a5b3fb94af732045a3f5a3d84574c"

inherit allarch wallpapers wallpapers-resize

ANIME_SELECTION_DIR = "${WALLPAPER_DIR}/anime-selection/2021Q2"
FILES_${PN} = "${ANIME_SELECTION_DIR}"

do_install() {
    install -d ${D}${ANIME_SELECTION_DIR}
    cp -rf ${S}/* ${D}${ANIME_SELECTION_DIR}
}
