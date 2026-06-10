import hmac
import hashlib

# WARNING - this is code only for a course exercise and should not be used for
# passwords in the real world!

key = "super secret key which nobody knows"
targeted = b'$\xed\xb8v\x10\x1f\xe2\xa6\xc2\x0f\xaf[\x98|\xc7\x84l\xe1H\x02"\xed\xbf\xde\xd7>/;.\x9bI\xdf'


def hide_password(pw):
    return hmac.new(bytes(key, 'utf-8'), bytes(pw, 'utf-8'), hashlib.sha256).digest()

def check_password(sig, pw):
    return hmac.compare_digest(hide_password(pw), sig)

def crack_password():
    chars = 'abcdefghijklmnopqrstuvwxyz0123456789'
    
    for c1 in chars:
        for c2 in chars:
            for c3 in chars:
                for c4 in chars:
                    foundpassword = c1 + c2 + c3 + c4
                                        
                    if check_password(targeted, foundpassword):
                        print(foundpassword)
                        break

crack_password()