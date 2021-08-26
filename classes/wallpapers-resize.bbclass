WALLPAPERS_RESCALE ?= "0"

WALLPAPERS_WORKDIR ?= "${S}"
WALLPAPERS_FILE_PATTERN ?= "*.*"
WALLPAPERS_RESCALE_WIDTH ?= "800"
WALLPAPERS_RESCALE_HEIGHT ?= "480"

OVERRIDES .= "${@bb.utils.contains('WALLPAPERS_RESCALE', '1', ':wallpaper-rescale', '', d)}"

DEPENDS:append_wallpaper-rescale = " imagemagick-native"

do_compile:append:wallpaper-rescale() {
    find ${WALLPAPERS_WORKDIR}/* -type f -name "${WALLPAPERS_FILE_PATTERN}" -exec mogrify.im7 -resize ${WALLPAPERS_RESCALE_WIDTH}X${WALLPAPERS_RESCALE_HEIGHT} {} \;
}
