from tkinter import* 

import os 


                                    
def Niveau1():
    os.system('laby-niveau-1.py')                       #lance le premier niveau du labyrinthe 

def Niveau2():
    os.system('laby-niveau-2.py')                       #lance le second niveau du labyrinthe 
    
def Niveau3():                                          #lance le troisième niveau du labyrinthe
    os.system('laby-niveau-3.py')


fen=Tk()                                                # création de la première fenetre 
fen.configure(bg='black', cursor='arrow')               # configuration de la couleur et la fenetre et de la fome de la souris 
fen.geometry('400x455')                                 # dimension de la fenetre 
fen.resizable(width=False, height=False)                # la largeur et la longueur de la fenetre ne peuvent pas etre modifié du fait des booléens
fen.title('Labyrinthe')                                 # titre de la fentre 

                                

titre=PhotoImage (file='Images/labyrinthe.png')

                    
labl=Label(fen,image=titre)                 
labl.pack(pady=10)  

                                 #Afficher le texte dans un label  
Titre=Canvas(fen,width=230,height=60,relief=GROOVE,bg='ghostwhite')                      #Création d'un canvas ( largeur, hauteur, couleur)
txt=Titre.create_text(110,30,text="LABYRINTHE",font="Helvetica 25 bold",fill='Black')    #Definition de l'interieur de canvas (texte, police, couleur)
Titre.pack(side=TOP)
                                                                            



Mode1=Button(fen,width=10,height=2,text='NIVEAU 1',font="Helvetica 15 bold",relief=GROOVE,cursor='hand2',command=Niveau1)      # Création du premier bouton ( largeur, hauteur,texte, police, encadré) 
Mode1.pack(pady=5)                                                                                                                # Permet a l'objet de s'afficher et de s'integrer dans la fenetre
Mode2=Button(fen,width=10,height=2,text='NIVEAU 2',font="Helvetica 15 bold",relief=GROOVE,cursor='hand2',command=Niveau2)      # Création du premier bouton ( largeur, hauteur,texte, police, encadré) 
Mode2.pack(pady=5)
Mode3=Button(fen,width=10,height=2,text='NIVEAU 3',font="Helvetica 15 bold",relief=GROOVE,cursor='hand2',command=Niveau3)      # Création du premier bouton ( largeur, hauteur,texte, police, encadré) 
Mode3.pack(pady=5)
 
fen.mainloop()                                          #Affichage de la fenetre principale
