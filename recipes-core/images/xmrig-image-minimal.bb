DESCRIPTION = "Core image with xmrig"

inherit core-image

IMAGE_INSTALL += " \
  htop \
  xmrig \
  xmrig-config \
  xmrig-service \
"
