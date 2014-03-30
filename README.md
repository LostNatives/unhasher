#unhasher

Unhasher helps you identify which hashing algorithm was used.

Supports different mutations:
* hash(pass)
* hash(pass.salt)
* hash(salt.pass)
* hash(salt1.pass.salt2)
* hash(salt2.pass.salt1)
* hash(salt2.salt1.pass)
* hash(salt1.salt2.pass)
* hash(pass.salt1.salt2)
* hash(pass.salt2.salt1)

##Instructions:

###Usage:
unhasher.jar -h HASH (-p PASSWORD | -w WORDLIST) [OPTIONAL_PARAMS]

* -h    Hash in any supported format.
* -p    Password.
* -w    Path to a wordlist file containing possible passwords separated by newline.
* -s    OPTIONAL: One or two salts, separated by ";".
* -i    OPTIONAL: Hash function iteration range, try 0-500 by default.
* -a    OPTIONAL: Specify algorithm, same notation as below.
* -x    OPTIONAL: Hash is in hex format.

Supported agorithms: MD5, SHA1, SHA256, SHA512, MySQL, MSSQL, NTLM, LM, bcrypt, DES

###Examples:
`java -jar unhasher.jar -h 098f6bcd4621d373cade4e832627b4f6 -p test`
`java -jar unhasher.jar -h 2a835530e9302131af7b3a11fc4b4f9d -w wordlist.txt -s test@test.com;tester -i 0-5000`
