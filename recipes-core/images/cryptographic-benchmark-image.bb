DESCRIPTION = "Image contains cryptopp-hash-benchmark"

inherit core-image

IMAGE_INSTALL:append = " cryptographic-hash-benchmark cpupower"
