#!/bin/sh

# You will need to install mono on osx to make this work.
# http://www.go-mono.com/mono-downloads/download.html
#compile:

if [ ! -d "target" ]; then
    mkdir -q target
fi

mcs -out:target/hello.exe src/main/csharp/hello.cs

mono target/hello.exe

mcs -out:target/Encapsulation.dll -t:library src/main/csharp/hello.cs
mcs -out:target/EncapsulationTest.dll -t:library -r:nunit.framework,target/Encapsulation.dll src/test/csharp/encapsulation/level_0/noEncapsulationTest.cs

nunit-console -xml=target/TestResult.xml target/EncapsulationTest.dll