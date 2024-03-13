PGDMP  ;                    |            LibraryManagement    16.1    16.1 .    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17348    LibraryManagement    DATABASE     �   CREATE DATABASE "LibraryManagement" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_Turkey.1254';
 #   DROP DATABASE "LibraryManagement";
                postgres    false            �            1259    17836    author    TABLE     �   CREATE TABLE public.author (
    birthdate date,
    id bigint NOT NULL,
    country character varying(255),
    name character varying(255)
);
    DROP TABLE public.author;
       public         heap    postgres    false            �            1259    17835    author_id_seq    SEQUENCE     v   CREATE SEQUENCE public.author_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.author_id_seq;
       public          postgres    false    216            �           0    0    author_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;
          public          postgres    false    215            �            1259    17845    book    TABLE     �   CREATE TABLE public.book (
    publicationyear integer NOT NULL,
    stock integer NOT NULL,
    author_id bigint,
    id bigint NOT NULL,
    publisher_id bigint,
    name character varying(255)
);
    DROP TABLE public.book;
       public         heap    postgres    false            �            1259    17851    book_category    TABLE     d   CREATE TABLE public.book_category (
    book_id bigint NOT NULL,
    category_id bigint NOT NULL
);
 !   DROP TABLE public.book_category;
       public         heap    postgres    false            �            1259    17844    book_id_seq    SEQUENCE     t   CREATE SEQUENCE public.book_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.book_id_seq;
       public          postgres    false    218            �           0    0    book_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;
          public          postgres    false    217            �            1259    17855    bookborrowing    TABLE     �   CREATE TABLE public.bookborrowing (
    borrowingdate date,
    id integer NOT NULL,
    returndate date,
    book_id bigint,
    borrowername character varying(255)
);
 !   DROP TABLE public.bookborrowing;
       public         heap    postgres    false            �            1259    17854    bookborrowing_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bookborrowing_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.bookborrowing_id_seq;
       public          postgres    false    221            �           0    0    bookborrowing_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.bookborrowing_id_seq OWNED BY public.bookborrowing.id;
          public          postgres    false    220            �            1259    17862    category    TABLE     �   CREATE TABLE public.category (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(255)
);
    DROP TABLE public.category;
       public         heap    postgres    false            �            1259    17861    category_id_seq    SEQUENCE     x   CREATE SEQUENCE public.category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.category_id_seq;
       public          postgres    false    223            �           0    0    category_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;
          public          postgres    false    222            �            1259    17871 	   publisher    TABLE     �   CREATE TABLE public.publisher (
    establishmentyear integer NOT NULL,
    id bigint NOT NULL,
    address character varying(255),
    name character varying(255)
);
    DROP TABLE public.publisher;
       public         heap    postgres    false            �            1259    17870    publisher_id_seq    SEQUENCE     y   CREATE SEQUENCE public.publisher_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.publisher_id_seq;
       public          postgres    false    225            �           0    0    publisher_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.publisher_id_seq OWNED BY public.publisher.id;
          public          postgres    false    224            2           2604    17839 	   author id    DEFAULT     f   ALTER TABLE ONLY public.author ALTER COLUMN id SET DEFAULT nextval('public.author_id_seq'::regclass);
 8   ALTER TABLE public.author ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            3           2604    17848    book id    DEFAULT     b   ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);
 6   ALTER TABLE public.book ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            4           2604    17858    bookborrowing id    DEFAULT     t   ALTER TABLE ONLY public.bookborrowing ALTER COLUMN id SET DEFAULT nextval('public.bookborrowing_id_seq'::regclass);
 ?   ALTER TABLE public.bookborrowing ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            5           2604    17865    category id    DEFAULT     j   ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);
 :   ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223            6           2604    17874    publisher id    DEFAULT     l   ALTER TABLE ONLY public.publisher ALTER COLUMN id SET DEFAULT nextval('public.publisher_id_seq'::regclass);
 ;   ALTER TABLE public.publisher ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225            �          0    17836    author 
   TABLE DATA           >   COPY public.author (birthdate, id, country, name) FROM stdin;
    public          postgres    false    216   M2       �          0    17845    book 
   TABLE DATA           Y   COPY public.book (publicationyear, stock, author_id, id, publisher_id, name) FROM stdin;
    public          postgres    false    218   �2       �          0    17851    book_category 
   TABLE DATA           =   COPY public.book_category (book_id, category_id) FROM stdin;
    public          postgres    false    219   �2       �          0    17855    bookborrowing 
   TABLE DATA           ]   COPY public.bookborrowing (borrowingdate, id, returndate, book_id, borrowername) FROM stdin;
    public          postgres    false    221   �2       �          0    17862    category 
   TABLE DATA           9   COPY public.category (id, description, name) FROM stdin;
    public          postgres    false    223   3       �          0    17871 	   publisher 
   TABLE DATA           I   COPY public.publisher (establishmentyear, id, address, name) FROM stdin;
    public          postgres    false    225   �3       �           0    0    author_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.author_id_seq', 1, true);
          public          postgres    false    215            �           0    0    book_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.book_id_seq', 1, true);
          public          postgres    false    217            �           0    0    bookborrowing_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.bookborrowing_id_seq', 1, true);
          public          postgres    false    220            �           0    0    category_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.category_id_seq', 2, true);
          public          postgres    false    222            �           0    0    publisher_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.publisher_id_seq', 1, true);
          public          postgres    false    224            8           2606    17843    author author_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.author DROP CONSTRAINT author_pkey;
       public            postgres    false    216            :           2606    17850    book book_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pkey;
       public            postgres    false    218            <           2606    17860     bookborrowing bookborrowing_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.bookborrowing
    ADD CONSTRAINT bookborrowing_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.bookborrowing DROP CONSTRAINT bookborrowing_pkey;
       public            postgres    false    221            >           2606    17869    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public            postgres    false    223            @           2606    17878    publisher publisher_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.publisher DROP CONSTRAINT publisher_pkey;
       public            postgres    false    225            A           2606    17879     book fk5gbo4o7yxefxivwuqjichc67t    FK CONSTRAINT     �   ALTER TABLE ONLY public.book
    ADD CONSTRAINT fk5gbo4o7yxefxivwuqjichc67t FOREIGN KEY (author_id) REFERENCES public.author(id);
 J   ALTER TABLE ONLY public.book DROP CONSTRAINT fk5gbo4o7yxefxivwuqjichc67t;
       public          postgres    false    4664    216    218            C           2606    17894 )   book_category fkgsuydtn8pg3h7qp3gg1f0lxp0    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_category
    ADD CONSTRAINT fkgsuydtn8pg3h7qp3gg1f0lxp0 FOREIGN KEY (book_id) REFERENCES public.book(id);
 S   ALTER TABLE ONLY public.book_category DROP CONSTRAINT fkgsuydtn8pg3h7qp3gg1f0lxp0;
       public          postgres    false    219    218    4666            B           2606    17884     book fkrb2njmkvio5mhe42empuaiphu    FK CONSTRAINT     �   ALTER TABLE ONLY public.book
    ADD CONSTRAINT fkrb2njmkvio5mhe42empuaiphu FOREIGN KEY (publisher_id) REFERENCES public.publisher(id);
 J   ALTER TABLE ONLY public.book DROP CONSTRAINT fkrb2njmkvio5mhe42empuaiphu;
       public          postgres    false    4672    218    225            D           2606    17889 )   book_category fkrky6eyov5ip2y5q9vkmnfghuy    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_category
    ADD CONSTRAINT fkrky6eyov5ip2y5q9vkmnfghuy FOREIGN KEY (category_id) REFERENCES public.category(id);
 S   ALTER TABLE ONLY public.book_category DROP CONSTRAINT fkrky6eyov5ip2y5q9vkmnfghuy;
       public          postgres    false    219    223    4670            E           2606    17899 )   bookborrowing fkt9qe8hg855iod1phiudt4cssm    FK CONSTRAINT     �   ALTER TABLE ONLY public.bookborrowing
    ADD CONSTRAINT fkt9qe8hg855iod1phiudt4cssm FOREIGN KEY (book_id) REFERENCES public.book(id);
 S   ALTER TABLE ONLY public.bookborrowing DROP CONSTRAINT fkt9qe8hg855iod1phiudt4cssm;
       public          postgres    false    218    4666    221            �   +   x�3�40�50"NCN��ļ�Tΰ���"�Pw�=... �'	      �   '   x�3�03�44�4C��b����+��rR��b���� ���      �      x�3�4�2�4����� ��      �   *   x�3202�50�52�4�����Eɉy
N�U\1z\\\ ��P      �   �   x�-��m�0���)n �@�A�}aeZ"���8���>���c�փ�D�$���ӱ�:�����zG�^�Έs�L��0ލ�{H/ȕ�r�����D;^�����:3�&�X���u����0T�&��D�n���4?�c�&�^��C� �R�̓���;pg+�|!m�q�)�
>�/�gI)���]�      �   +   x�3200�4�<���$1/�4��91O�;�$1)�,�+F��� �\
�     