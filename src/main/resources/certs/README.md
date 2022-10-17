# generate private key
`openssl genrsa -out keypair.pem 2048`

# generate public key
`openssl rsa -in keypair.pem -pubout -out public.pem`

# change the format of private key
`openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem`

Then we can delete `keypair.pem`