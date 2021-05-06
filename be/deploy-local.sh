cd ./server
git checkout deploy/prod
git fetch

LOCAL=`git rev-parse HEAD`
REMOTE=`git rev-parse origin/deploy/prod`
if [[ $LOCAL == $REMOTE ]]; then
    echo "@@@@ No need to deploy"
    exit 0
fi

git merge

sh ./run.sh
