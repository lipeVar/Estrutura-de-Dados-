#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

typedef struct no {
    int valor;
    struct no *esq;
    struct no *dir;
} Arvore;

//metodo inserir recursivo em arvore binaria de pesquisa
Arvore* inserir(int valor, Arvore *raiz) {
    if(raiz) {
        //Controle de duplicidade
        if(valor == raiz->valor) {
            return raiz;
        }
        if(valor<raiz->valor) {
            raiz->esq = inserir(valor, raiz->esq);
        } else {  //ir para direita
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    } else {
        Arvore *novo;
        novo = (Arvore*)malloc(sizeof(Arvore));
        novo->valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        return novo;
    } 
}

void red(Arvore *raiz) {
    if(raiz) {
        cout << raiz->valor << "\t";
        red(raiz->esq);
        red(raiz->dir);
    }
}

void erd(Arvore*raiz) {
    if(raiz) {
        erd(raiz->esq);
        cout << raiz->valor << "\t";
        erd(raiz->dir);
    }
}

void edr(Arvore*raiz) {
    if(raiz) {
        edr(raiz->esq);
        edr(raiz->dir);
        cout << raiz->valor << "\t";
    }
}

void exibir(int nivel, Arvore *raiz) {
    if(raiz) {
        exibir(nivel+1, raiz->dir);

        for(int i=0; i<nivel; i++) {
            cout << "   ";
        }
        cout << raiz->valor << "(" << nivel << ")\n";
        
        exibir(nivel+1, raiz->esq);
    }
}

int contar(Arvore *raiz) {
    if(raiz) {
        return 1 + contar(raiz->esq) + contar(raiz->dir);
    }
    return 0;
}

int contarFolhas(Arvore *raiz) {
    if(raiz) {
        if (!raiz->esq && !raiz->dir) {
            return 1;
        }
        return 0 + contarFolhas(raiz->esq) + contarFolhas(raiz->dir);
    }
    return 0;
}

int menor(Arvore *raiz) {
    if(!raiz) return -27;

    Arvore *p;
    for(p=raiz; p->esq; p=p->esq);
    return p->valor;
}

int maior(Arvore *raiz) {
    if(!raiz) return -27;

    Arvore *p;
    for(p=raiz; p->dir; p=p->dir);
    return p->valor;
}

int encontrou(Arvore *raiz, int valor) {
    if(raiz) {
        if(valor == raiz->valor) {
            return 1; //encontrou
        }
        if(valor<raiz->valor) {
            return encontrou(raiz->esq, valor);
        } else {  //ir para direita
            return encontrou(raiz->dir, valor);
        }
    }
    return 0; //nao encontrou
}

int nivel(int valor, Arvore *raiz) {
    if(raiz) {
        if(valor == raiz->valor) return 0;
        if(valor<raiz->valor) {
            int resp = nivel(valor, raiz->esq);
            if(resp == -1) return -1;
            return resp +1;
        } else{
            int resp = nivel(valor, raiz->dir);
            if(resp == -1) return -1;
            return resp +1;
        }
    }
    return -1; //nao encontrado
}

int main() {
    Arvore *raiz = NULL;
    srand(time(NULL));
    for(int i=0; i<20; i++) {
        raiz = inserir(rand() % 30, raiz);
    }
    // raiz = inserir(100, raiz);
    // raiz = inserir(50, raiz);
    // raiz = inserir(150, raiz);
    // raiz = inserir(80, raiz);
    // raiz = inserir(60, raiz);
    //erd(raiz);
    //red(raiz);
    //edr(raiz);

    exibir(0,raiz);
    cout << "Total de elementos:" << contar(raiz) << "\n";
    cout << "Total de folhas:" << contarFolhas(raiz) << "\n";
    cout << "Menor valor: " << menor(raiz) << "\n";
    cout << "Maior valor: " << maior(raiz) << "\n";

    int valor = 5;
    cout << "Encontrou " << valor << "? " << encontrou(raiz, valor) << "\n";
    cout << "Nível de " << valor << ": " << nivel(valor, raiz) << "\n";
    return 1;
}