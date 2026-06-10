from faker import Faker

fake = Faker('en_GB')

#REMINDER OF FAKER USAGE
#>>> from faker import Faker
#>>> fake = Faker()
#>>> fake.name()

#    for _ in range(10):
#      print(fake.name())

#surname = fake.last_name()
#address = fake.address()
#automotive = fake.license_plate()
name = fake.name()
print(name)

with open(f"target_directory/originals/{name}", "w") as f:
    #f.write(surname)
    f.write(f"Full Name: {name}\n")
    f.write(f"Address: {fake.address()}\n")

with open("target_directory/allowlist", "w") as f:
    f.write(name)

#with open("target_directory/droplist", "w") as f:
#    f.write(name)