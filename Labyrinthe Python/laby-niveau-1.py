from tkinter import *
import os
from timeit import default_timer


#####################################

fen1 = Tk()
fen1.title("labyrinthe")

fond=PhotoImage (file='Images/foret.png')


canvas = Canvas(fen1, width=800, height=550, background='white')
canvas.pack()
fond=PhotoImage (file='Images/foret.png')
canvas.create_image(390,250,image=fond)

fen1.geometry("800x600") 
fen1.resizable(width=False, height=False)


canvas.pack()


#####################################


#Fonction avancer
def avance():
    global joueur
    canvas.coords(carre,20*joueur[0],20*joueur[1],20*joueur[0]+20,20*joueur[1]+20)
    if tableau[joueur[1]+1][joueur[0]]==5:
        canvas.delete(ALL)
        txt=canvas.create_text(390, 150, text="Victoire", font="Arial 120 italic", fill="green")
        txt=canvas.create_text(350, 300, text= default_timer()- start ,font="Arial 50 italic", fill="green")
        txt=canvas.create_text(690, 300, text='s',font="Arial 50 italic", fill="red")




#chronomètre
def chrono():
    
        now = default_timer() - start
        minutes, seconds = divmod(now, 60)
        hours, minutes = divmod(minutes, 60)
        str_time = "%d:%02d:%02d" % (hours, minutes, seconds)
        canvas.itemconfigure(text_clock, text=str_time)
        fen1.after(1000, chrono)

start = default_timer()
text_clock = canvas.create_text(400, 10)
stop=default_timer()



chrono()



#condition de déplacement
def bas(event):
    global joueur
    if tableau[joueur[1]+1][joueur[0]]==0:
        joueur=[joueur[0],joueur[1]+1]
    avance()
def haut(event):
    global joueur
    if tableau[joueur[1]-1][joueur[0]]==0:
        joueur=[joueur[0],joueur[1]-1]
    avance()
def gauche(event):
    global joueur
    if tableau[joueur[1]][joueur[0]-1]==0:
        joueur=[joueur[0]-1,joueur[1]]
    avance()
def droite(event):
    global joueur
    if tableau[joueur[1]][joueur[0]+1]==0:
        joueur=[joueur[0]+1,joueur[1]]
    avance()


#lance le niveau suivant
def NiveauSuivant():
    os.system('laby-niveau-2.py')      

#permet de recommancer le niveau
def Recommencer():
    canvas.delete(ALL)
    os.system('laby-niveau-1.py')

######################### CREATION DU LABYRINTHE ###################################
tableau= [
   [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
    [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],
    [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
    [1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1],
    [1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1],
    [1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1],
    [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,1,0,1],
    [1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1],
    [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,1,1],
    [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1],
    [1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,1,1,0,1],
    [1,0,0,1,0,0,1,0,1,0,0,1,1,1,0,1,0,0,1,0,0,0,0,1,0,1,1,1,1,1,1,0,0,1,0,1,0,0,0,1],
    [1,0,1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,0,1,0,1,1,1,1,0,1,0,0,0,0,1,0,0,1,0,1,0,0,0,1],
    [1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1],
    [1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1],
    [1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1],
    [1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1],
    [1,0,1,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,1],
    [1,0,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,0,1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,1],
    [1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1,1,0,1,0,1],
    [1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1],
    [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,1],
    [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1],
    [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1],
    [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,0,2],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0]]
for ligne in range (27):
    for i in range (40):

        if tableau[ligne][i]==1:
            canvas.create_rectangle(20*i,20*ligne,20*i+20,20*ligne+20,fill="gray")
        elif tableau[ligne][i]==2:
            canvas.create_rectangle(20*i,20*ligne,20*i+20,20*ligne+20,fill="red")
        elif tableau[ligne][i]==4:
            canvas.create_rectangle(20*i,20*ligne,20*i+20,20*ligne+20,fill="brown")






joueur=[27
        ,1]          #On définit la position du joueur

Mode1=Button(fen1,width=12,height=2,text='Niveau suivant',font="Helvetica 15 bold",relief=GROOVE,cursor='bogosity',command=NiveauSuivant)  # Création du premier bouton ( largeur, hauteur,texte, police, encadré) 
Mode1.pack(pady=5, side= RIGHT)                              

Mode2=Button(fen1,width=14,height=2,text='Recommencer',font="Helvetica 15 bold",relief=GROOVE,cursor='rtl_logo',command=Recommencer)     #Création d'un second bouton                   
Mode2.pack(pady=5, side= LEFT)

carre=canvas.create_rectangle(20*joueur[0],20*joueur[1],20*joueur[0]+20,20*joueur[1]+20,fill="Blue")  #création du joueur (dimension + couleur)

fen1.bind("<Left>",gauche)         
fen1.bind("<Right>",droite)
fen1.bind("<Up>",haut)
fen1.bind("<Down>",bas)

fen1.bind("<q>",gauche)         
fen1.bind("<d>",droite)
fen1.bind("<z>",haut)
fen1.bind("<s>",bas)

fen1.mainloop()

