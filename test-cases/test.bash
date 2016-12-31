#!/bin/bash
#the command chmod +x test.bash need to run to give permission
full_path=$(pwd)
for requirement_dir in $full_path/*/; 
do
  cd $requirement_dir
  cd input
  for filename in *.txt;
  do
    #reading inputs from input file
    input=$(cat $filename)
    #end of reading input, now read output
    cd $full_path
    cd $requirement_dir
    cd output
    expected_output=$(cat $filename)
    #end of reading output, now run test
    cd $full_path
    cd ..
    cd TestingProject/bin/
    echo "running file: $filename and input: $input in the following directory"
    pwd
    actual_output=$(java Main $input)
    #end of test, now put the result the corresponding file name in the program-output directory
    cd $full_path
    cd $requirement_dir
    cd program-output
    echo "$actual_output" > "$filename"
    #finished everything for this the specific file, now reset the directory
    cd $requirement_dir
    cd input
  done
  cd $full_path
done