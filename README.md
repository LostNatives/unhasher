#unhasher

Unhasher helps you identify which hashing algorithm was used.

##Instructions:

unhasher.jar -h <hash> (-p <password> | -w <wordlist>) [OPTIONS]

* -h    Hash in any supported format.
* -p    Password.
* -w    Path to a wordlist file containing possible passwords separated by newline.
* -s    OPTIONAL: One or more salts, separated by ";".
* -i    OPTIONAL: Hash function iteration range, try 0-500 by default.
* -a    OPTIONAL: Specify algorithm, same notation as below.
* -x    OPTIONAL: Hash is in hex format.

Supported agorithms: MD5, SHA1, SHA256, SHA512, MySQL, MSSQL, NTLM, LM, bcrypt, DES

###Examples:
`unhasher.jar -h 098f6bcd4621d373cade4e832627b4f6 -p test`
`unhasher.jar -h 098f6bcd4621d373cade4e832627b4f6 -w wordlist.txt -s test@test.com;tester -i 0-5000 -a SHA256`
