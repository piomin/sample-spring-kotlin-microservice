#! /bin/bash

for OUTPUT in $(git branch -r)
do
  branch=$(echo $OUTPUT | sed -e "s/^origin\///")
  if [[ $branch == feature* ]]
  then
    echo "Running the pipeline: branch="$branch
    tkn pipeline start sample-pipeline -p branch=$branch -p namespace=app-$branch -w name=source-dir,volumeClaimTemplateFile=pvc.yaml >/dev/null
  fi
done