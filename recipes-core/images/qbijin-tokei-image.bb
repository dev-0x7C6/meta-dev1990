DESCRIPTION = "Image contains qbijin-tokei"

inherit core-image

IMAGE_INSTALL_append = " qbijin-tokei packagegroup-bijin-assets"
