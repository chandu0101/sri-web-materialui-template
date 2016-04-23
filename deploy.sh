#!/bin/sh

#Handy script to deploy app to github pages(gh-pages)

# get comment
comment="$1"

rm -rf assets

sbt clean

sbt fullOptJS

npm install

npm run build


if [ "$comment" == "" ]; then
comment="push from CI"
echo "no comment specified to deploy, using default : $comment"
fi

projectName="sri-web-materialui"

ghPagesPath="/Users/chandrasekharkode/Desktop/Kode/Programming/scalaprojects/chandu0101.github.io"

projectPath=${ghPagesPath}/${projectName}

mkdir -p ${projectPath}/assets

cp index.html ${projectPath}

cp -r assets/ ${projectPath}/assets/

cd ${ghPagesPath}

git add ${projectName}

git commit -m "$comment"

git push