DESCRIPTION = "Core image with xmrig"

inherit core-image

IMAGE_INSTALL += " \
  xmrig \
  xmrig-config \
  xmrig-service \
"