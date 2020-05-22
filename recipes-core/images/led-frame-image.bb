DESCRIPTION = "Image contains led-frame and configuration"

inherit core-image

IMAGE_INSTALL_append = " \
  led-frame \
  wpa-supplicant \
"
