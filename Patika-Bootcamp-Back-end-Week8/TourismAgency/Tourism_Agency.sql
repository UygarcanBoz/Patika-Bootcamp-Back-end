PGDMP  4    9                |            Tourism_Agency    16.1    16.1 "    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17167    Tourism_Agency    DATABASE     �   CREATE DATABASE "Tourism_Agency" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_Turkey.1254';
     DROP DATABASE "Tourism_Agency";
                postgres    false            �            1259    17169    hotel    TABLE       CREATE TABLE public.hotel (
    hotel_id bigint NOT NULL,
    name text NOT NULL,
    star text NOT NULL,
    property text NOT NULL,
    address text NOT NULL,
    city text NOT NULL,
    region text NOT NULL,
    phone text NOT NULL,
    email text NOT NULL,
    full_board integer NOT NULL,
    half_board integer NOT NULL,
    all_inclusive integer NOT NULL,
    ultra_all_inclusive integer NOT NULL,
    non_alcohol integer NOT NULL,
    bed_and_breakfast integer NOT NULL,
    room_only integer NOT NULL
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    17168    hotel_hotel_id_seq    SEQUENCE     �   ALTER TABLE public.hotel ALTER COLUMN hotel_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.hotel_hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    17177    pricing    TABLE     �   CREATE TABLE public.pricing (
    pricing_id bigint NOT NULL,
    pricing_room_id bigint NOT NULL,
    room_price_for_adult bigint NOT NULL,
    room_price_for_child bigint NOT NULL,
    pricing_season_name text NOT NULL,
    hostel_type text NOT NULL
);
    DROP TABLE public.pricing;
       public         heap    postgres    false            �            1259    17176    pricing_pricing_id_seq    SEQUENCE     �   ALTER TABLE public.pricing ALTER COLUMN pricing_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pricing_pricing_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    17185    reservation    TABLE     �  CREATE TABLE public.reservation (
    reservation_id bigint NOT NULL,
    reservation_room_id bigint NOT NULL,
    reservation_note text NOT NULL,
    reservation_price bigint NOT NULL,
    reservation_checkin text NOT NULL,
    reservation_checkout text NOT NULL,
    reservation_visitors bigint NOT NULL,
    reservation_name text NOT NULL,
    reservation_idno bigint NOT NULL,
    reservation_age bigint NOT NULL,
    reservation_tel text NOT NULL,
    reservation_email text NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    17184    reservation_reservation_id_seq    SEQUENCE     �   ALTER TABLE public.reservation ALTER COLUMN reservation_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reservation_reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �            1259    17193    room    TABLE     �  CREATE TABLE public.room (
    room_id bigint NOT NULL,
    room_hotel_id bigint NOT NULL,
    room_name text NOT NULL,
    room_stock integer NOT NULL,
    room_capacity integer NOT NULL,
    room_area integer NOT NULL,
    room_tv integer NOT NULL,
    room_bar integer NOT NULL,
    room_projector integer NOT NULL,
    room_gaming integer NOT NULL,
    room_bank integer NOT NULL
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    17192    room_room_id_seq    SEQUENCE     �   ALTER TABLE public.room ALTER COLUMN room_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.room_room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222            �            1259    17201    season    TABLE     �   CREATE TABLE public.season (
    season_id bigint NOT NULL,
    season_hotel_id bigint NOT NULL,
    season_name text NOT NULL,
    season_start text NOT NULL,
    season_end text NOT NULL
);
    DROP TABLE public.season;
       public         heap    postgres    false            �            1259    17200    season_season_id_seq    SEQUENCE     �   ALTER TABLE public.season ALTER COLUMN season_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.season_season_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    17209    user    TABLE     �   CREATE TABLE public."user" (
    id bigint NOT NULL,
    name text NOT NULL,
    uname text NOT NULL,
    pass text NOT NULL,
    type text NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    17208    user_id_seq    SEQUENCE     �   ALTER TABLE public."user" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226            �          0    17169    hotel 
   TABLE DATA           �   COPY public.hotel (hotel_id, name, star, property, address, city, region, phone, email, full_board, half_board, all_inclusive, ultra_all_inclusive, non_alcohol, bed_and_breakfast, room_only) FROM stdin;
    public          postgres    false    216   ]*       �          0    17177    pricing 
   TABLE DATA           �   COPY public.pricing (pricing_id, pricing_room_id, room_price_for_adult, room_price_for_child, pricing_season_name, hostel_type) FROM stdin;
    public          postgres    false    218   +       �          0    17185    reservation 
   TABLE DATA           	  COPY public.reservation (reservation_id, reservation_room_id, reservation_note, reservation_price, reservation_checkin, reservation_checkout, reservation_visitors, reservation_name, reservation_idno, reservation_age, reservation_tel, reservation_email) FROM stdin;
    public          postgres    false    220   r+       �          0    17193    room 
   TABLE DATA           �   COPY public.room (room_id, room_hotel_id, room_name, room_stock, room_capacity, room_area, room_tv, room_bar, room_projector, room_gaming, room_bank) FROM stdin;
    public          postgres    false    222   �+       �          0    17201    season 
   TABLE DATA           c   COPY public.season (season_id, season_hotel_id, season_name, season_start, season_end) FROM stdin;
    public          postgres    false    224   <,       �          0    17209    user 
   TABLE DATA           =   COPY public."user" (id, name, uname, pass, type) FROM stdin;
    public          postgres    false    226   �,       �           0    0    hotel_hotel_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 3, true);
          public          postgres    false    215            �           0    0    pricing_pricing_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.pricing_pricing_id_seq', 2, true);
          public          postgres    false    217            �           0    0    reservation_reservation_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.reservation_reservation_id_seq', 4, true);
          public          postgres    false    219            �           0    0    room_room_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.room_room_id_seq', 3, true);
          public          postgres    false    221            �           0    0    season_season_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.season_season_id_seq', 4, true);
          public          postgres    false    223            �           0    0    user_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.user_id_seq', 5, true);
          public          postgres    false    225            4           2606    17175    hotel hotel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    216            6           2606    17183    pricing pricing_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pricing
    ADD CONSTRAINT pricing_pkey PRIMARY KEY (pricing_id);
 >   ALTER TABLE ONLY public.pricing DROP CONSTRAINT pricing_pkey;
       public            postgres    false    218            8           2606    17191    reservation reservation_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reservation_idno);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    220            :           2606    17199    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    222            <           2606    17207    season season_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (season_id);
 <   ALTER TABLE ONLY public.season DROP CONSTRAINT season_pkey;
       public            postgres    false    224            >           2606    17215    user user_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    226            �   �   x�u�A
�0���)<�03m݊x�n����$�л.��(���(��bf3��3MG������T[7�v�:\�Co�ބ@�4q x�k�%s*���%*�O#���/�ѻ�i�x�o�'�_v"��R
�����?�*ѥ�#�:)��忒���"���(��d�UϕR�#\�      �   D   x�3�4�4400�4��#���,���U��˩�2�B�$XD6)5E!1/E!�(51;-���+F��� �0      �   h   x�E�;�0Cg�\ ��]�8Ka@���� ��*u<��y��X�"��+���	�=ų���P�K�o�mq^] Mˬ��P0��q73s�앹����s�+�      �   B   x�3�4�,��K�I2��� B� ��gJ~iP�44E�4�4�,.�,�4I����H�=... �M�      �   Y   x�3�4��>���|NC]C#]##c���4�2�4����NJ�H,B3� J�9�9+����LK��	�	gq~� K��u&\1z\\\ e�Z      �   Q   x�3�LL�DNC#c�Ĕ��<.#Τ$ J����W��re��(M؄3�8�A��)gbFq^JPSFqJ:�d� ��#�     