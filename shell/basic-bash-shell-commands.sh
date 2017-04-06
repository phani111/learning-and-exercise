# traversing directories
cd /usr/bin

# present working directory
pwd

# list files and directories
# - display a basic listing
ls

# - distinguish files and directories
ls -F

# - display hidden files and directories
ls -a

# - recursive option: sub directories and files
ls -R

# - diplay a long listing
ls -l

# - filtering listing output (? represents on character, * represents any number of characters)
ls -l kafka*
ls -l kafka?

# creating files
touch test_one

# change the access time
touch -a test_one

# copy files
cp test_one test_two

# copy files - force confirm overwrite
cp -i test_one test_two

# copy file to an existing directory
cp test_one ~/Documents/

# recursively copy
cp -R scripts/ Mod_scripts

# wildcard match copy
cp *script Mod_scripts/

# Link files
# create a symbolic to a file
ln -s data_file sl_data_file