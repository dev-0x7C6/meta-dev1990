DESCRIPTION = "Image contains qbijin-tokei"

inherit core-image

IMAGE_INSTALL += " \
  tzdata \
  packagegroup-bijin-assets \
  qbijin-tokei \
  qbijin-tokei-service \
"
