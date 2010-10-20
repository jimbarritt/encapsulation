#!/bin/sh

# You will need to install mono on osx to make this work.
# http://www.go-mono.com/mono-downloads/download.html
#compile:

if [ ! -d "target" ]; then
    mkdir -q target
fi

mcs -out:target/hello.exe src/main/csharp/hello.cs

mono target/hello.exe
