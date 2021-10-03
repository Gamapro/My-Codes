

class Set:

    def __init__(self, tam = 13, pot = 26):
        self.table = [[] for i in range(tam)]
        self.mod = tam
        self.pot = pot


    def __str__(self):
        s = ""
        for index, lista in enumerate(self.table):
            s+="Index: "+("" if index >= 10 else " ")+str(index)+" - "+str(lista)+"\n"
        return s


    def insert(self, data):
        hashValue = self.calcHash(data)
        self.table[hashValue].append(data)
        return 


    def contains(self, data):
        hashValue = self.calcHash(data)
        return True if data in self.table[hashValue] else False


    def remove(self, data):
        hashValue = self.calcHash(data)
        if data in self.table[hashValue]:
            self.table[hashValue].remove(data)
        return 


    def calcHash(self, data):
        hashValue = 0
        if type(data) == str:
            hashValue = self.calcStringHash(data)
        else:
            hashValue = data % self.mod
        return hashValue


    def calcStringHash(self, s):
        val = 0      
        pot = 1
        for i in range(len(s)):
        #       previo  valor de s[i]     valor de dig^i         modulo
            val = (val + (ord(s[i]) * pot )) % self.mod
            pot = (pot * self.pot) % self.mod
        return val



