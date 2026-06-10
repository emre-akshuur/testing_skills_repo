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

#If allowlist doesn't exist in document_updater directory, use this first and comment out the second allowlist prompt below!
# with open("target_directory/allowlist", "w") as f:
#     f.write(name)

#Use this if allowlist exist in document_updater directory to add the data to the list correctly without overwriting already existing data.
with open("target_directory/allowlist", "a") as f:
   f.write(f"\n")
   f.write(name)

#If droplist doesn't exist in document_updater directory, use this first and comment out the second droplist prompt below!
#with open("target_directory/droplist", "w") as f:
#    f.write(name)

#Use this if droplist exist in document_updater directory to add the data to the list correctly without overwriting already existing data.
# with open("target_directory/droplist", "a") as f:
#    f.write(f"\n")
#    f.write(name)