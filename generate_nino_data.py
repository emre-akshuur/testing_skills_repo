import random

#Neither of the first two letters can be D, F, I, Q, U or V. The second letter also cannot be O. The prefixes BG, GB, NK, KN, TN, NT and ZZ are not allocated.
#The suffix letter is either A, B, C, or D.
FIRST_CHARACTER = "ABCEGHJKLMNOPRSTWXYZ"
#SECOND_CHARACTER = "ABCEGHJKLMNPRSTWXYZ"
ALLOWED_SUFFIX = "ABCD"
    
#file_out = open("output.txt", "w")
ninos = []
    
for i in range(1000):
    letter1 = random.choice(FIRST_CHARACTER)
    letter2 = random.choice(FIRST_CHARACTER)
    prefix = letter1 + letter2
        
    if prefix not in ["BG", "GB", "NK", "KN", "TN", "NT", "ZZ"] and prefix[1] != "O":
            
        num1 = random.choice("0123456789")
        num2 = random.choice("0123456789")
        num3 = random.choice("0123456789")
        num4 = random.choice("0123456789")
        num5 = random.choice("0123456789")
        num6 = random.choice("0123456789")
    
    suffix = random.choice(ALLOWED_SUFFIX)
    
    nino = prefix + num1 + num2 + num3 + num4 + num5 + num6 + suffix
    print(nino)
    
    #ninos.append(nino)
#with open("ninolist.txt", "w") as f:
    #for nino in ninos:
        #f.write(nino + "\n")
    

#print(ninos)
    #file_out.write(nino + "\n")
#file_out.close()
