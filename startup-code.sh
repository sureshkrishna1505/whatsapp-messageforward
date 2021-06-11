#!/bin/bash
cd `dirname $0`


img_mvn="maven:3.3.3-jdk-8"                 # docker image of maven
m2_cache=~/.m2                              # the local maven cache dir
proj_home=$PWD                              # the project root dir
img_output="deep/messageforward"         # output image tag


git pull  # should use git clone https://name:pwd@xxx.git


if which mvn ; then
    echo "use local maven"
    mvn clean package
else
    echo "use docker maven"
    docker run --rm \
        -v $m2_cache:/root/.m2 \
        -v $proj_home:/usr/src/mymaven \
        -w /usr/src/mymaven $img_mvn mvn clean package
fi


sudo mv $proj_home/target/messageforward-*-SNAPSHOT.jar $proj_home/target/messageforward.jar # 兼容所有sh脚本
docker build -t $img_output .

./startup-image.sh
