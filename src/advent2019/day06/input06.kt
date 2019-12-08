package advent2019.day06

val input = listOf(
    """QVP)6MB""",
    """LV9)5WD""",
    """GR7)XGM""",
    """C8M)192""",
    """LB7)MRT""",
    """LW8)9TT""",
    """HDK)71F""",
    """WR1)6L1""",
    """4DC)QF7""",
    """BC5)55B""",
    """DFB)B26""",
    """MSQ)4WW""",
    """ZD9)SRZ""",
    """D1C)N9G""",
    """SD4)7N7""",
    """J1L)FXM""",
    """42B)CF2""",
    """BQ3)M69""",
    """G1F)6M5""",
    """7TM)FHK""",
    """H9T)MMV""",
    """XDR)P4X""",
    """ZPJ)5LB""",
    """PTX)DV8""",
    """DFR)HR4""",
    """XSG)XDD""",
    """S1L)DHC""",
    """K2V)FTJ""",
    """P1Z)TM4""",
    """PPK)GMS""",
    """SMN)8BV""",
    """C11)ZMK""",
    """XL2)MNG""",
    """3TN)7WV""",
    """4TC)NJ7""",
    """G58)MXQ""",
    """WHS)JXZ""",
    """ZV8)614""",
    """1N6)85Z""",
    """Z5J)L6S""",
    """RSN)7NQ""",
    """918)4TW""",
    """T14)9BV""",
    """WKQ)C3N""",
    """63C)N4H""",
    """S29)5HG""",
    """SMR)H1B""",
    """RYD)M68""",
    """4VF)MSN""",
    """B9W)S3M""",
    """KCM)34S""",
    """JQJ)3CB""",
    """913)T8G""",
    """318)5GN""",
    """VG8)42B""",
    """JNK)LVW""",
    """YL3)5C4""",
    """J7C)4MP""",
    """SQG)VRB""",
    """SBT)R3Q""",
    """V8V)G2T""",
    """T8R)BTQ""",
    """XKR)T8R""",
    """3F1)TKT""",
    """YR9)J7C""",
    """CT4)MF8""",
    """TM4)4M6""",
    """4BS)HJT""",
    """P9L)3Q8""",
    """2XF)QKC""",
    """9PC)TVD""",
    """Y13)D33""",
    """QJ1)VL5""",
    """BW3)DFF""",
    """HMR)BC5""",
    """G1W)3VJ""",
    """K21)9B4""",
    """YKV)GWR""",
    """M5S)1V9""",
    """PHP)S1Z""",
    """6S6)Q8V""",
    """6NS)TMP""",
    """M2F)LYR""",
    """F44)2S9""",
    """2WP)MDT""",
    """S8Z)D3T""",
    """T5B)H4J""",
    """782)ZQW""",
    """LWF)7SG""",
    """GPD)T26""",
    """WLV)1WY""",
    """TJG)SR3""",
    """6KG)K2Q""",
    """BRY)6YB""",
    """FML)8L4""",
    """ZMK)KTQ""",
    """H5Z)XL2""",
    """9CJ)4WX""",
    """Y3Z)TVN""",
    """HL8)MTZ""",
    """FJ8)1BZ""",
    """N59)MKL""",
    """F8B)Q7W""",
    """4Y9)Q7N""",
    """CW7)J1K""",
    """ZJP)RYD""",
    """B2M)W4V""",
    """TZY)THB""",
    """4JP)4D3""",
    """D3D)76Y""",
    """68Y)Y8G""",
    """JP1)6SV""",
    """JXZ)2Z5""",
    """5F5)5PL""",
    """T8G)DFR""",
    """4DZ)PH3""",
    """N52)429""",
    """465)8T3""",
    """391)X4D""",
    """H2H)8FR""",
    """PDZ)VHW""",
    """MK3)4LN""",
    """6NZ)LR8""",
    """7T5)2WP""",
    """7YB)1DW""",
    """LZW)66H""",
    """KJ5)R2P""",
    """4KQ)14X""",
    """6PV)TJR""",
    """7DQ)M9F""",
    """G1T)C3V""",
    """F4G)SGS""",
    """8CF)Q3V""",
    """Q4J)4NR""",
    """Q7L)Z4V""",
    """X67)T8C""",
    """ZPD)MGK""",
    """QT4)WL2""",
    """53G)NFQ""",
    """XJD)KQQ""",
    """GMS)F85""",
    """J4D)HCH""",
    """NFD)K2P""",
    """TM3)P18""",
    """RB5)CVS""",
    """MWB)TWQ""",
    """FSC)GJV""",
    """8SV)JP1""",
    """T4C)DX4""",
    """K2Q)DBF""",
    """BLY)TM3""",
    """YB5)J5K""",
    """7T5)9RJ""",
    """Y6X)3TL""",
    """JLM)43X""",
    """NGK)SLN""",
    """3Q8)RV4""",
    """JZ2)TQK""",
    """YQL)ZDP""",
    """LP9)TCD""",
    """SF5)Y84""",
    """WH8)JJX""",
    """N1S)5RC""",
    """QKC)3RF""",
    """VV3)YK6""",
    """5XB)TZY""",
    """4HG)6H3""",
    """Q1G)TLD""",
    """FXV)LRV""",
    """W4V)V12""",
    """MGK)2WY""",
    """SFM)MFF""",
    """F8Z)7GH""",
    """8GD)RP8""",
    """F85)LP9""",
    """ZL1)RF9""",
    """RSN)7RG""",
    """2YS)KTP""",
    """TM3)M4K""",
    """MSN)JCG""",
    """Y7V)67Y""",
    """YK6)318""",
    """2Z7)P1Z""",
    """7FN)4NX""",
    """Y3Z)8WM""",
    """M68)6P7""",
    """WCS)XVH""",
    """KBQ)13D""",
    """6W1)PM3""",
    """S7L)CFX""",
    """ZT6)2YS""",
    """NN1)25W""",
    """34S)LHH""",
    """16J)RHJ""",
    """WHL)7GR""",
    """M77)M5S""",
    """DKJ)VCB""",
    """469)FQX""",
    """HCH)29W""",
    """4TW)3LN""",
    """4Y9)F8Z""",
    """S76)BLY""",
    """T2H)Y98""",
    """ZYY)RRR""",
    """TX7)ZDM""",
    """3MY)1SR""",
    """TTV)61V""",
    """HNR)S93""",
    """4S4)VG7""",
    """YLR)DQW""",
    """T8G)1N6""",
    """55B)CFK""",
    """2H7)51W""",
    """BZ1)WVV""",
    """NL2)T14""",
    """6V7)XGB""",
    """HBV)5Z9""",
    """MMB)JHK""",
    """QYF)H1P""",
    """QQT)XHF""",
    """KJ5)N3H""",
    """5YB)PFV""",
    """SLN)6R9""",
    """D56)SBF""",
    """JHK)QJ3""",
    """QCT)DLY""",
    """F54)TPF""",
    """9ZC)WYL""",
    """YJF)L1V""",
    """CYC)KD6""",
    """1B1)6XR""",
    """FVK)NFD""",
    """VBB)Q7L""",
    """MTZ)PJX""",
    """CSX)VF1""",
    """5RC)YGQ""",
    """X4D)W99""",
    """VF1)XG9""",
    """SRZ)XPC""",
    """NZZ)V87""",
    """COM)RC1""",
    """FFH)J9K""",
    """RMG)7F9""",
    """SDL)2XC""",
    """ZBM)2XH""",
    """TSH)HMH""",
    """G7T)3KC""",
    """237)M13""",
    """V1M)7V2""",
    """6Q8)H8M""",
    """DQ2)XQ5""",
    """SBS)M45""",
    """PX1)7QV""",
    """FTS)HGR""",
    """C69)V8Z""",
    """KGG)687""",
    """J55)PNS""",
    """M9F)B3C""",
    """5Z9)LJ3""",
    """CFX)HTM""",
    """J7C)HLN""",
    """34L)46J""",
    """H1P)HKJ""",
    """M69)8ZY""",
    """NYP)NQS""",
    """DBC)CMX""",
    """MBW)SGF""",
    """7C1)6NZ""",
    """PBL)CH6""",
    """DCW)TMM""",
    """3MX)WZG""",
    """8JC)7KG""",
    """VBG)BZZ""",
    """2L2)GXW""",
    """9XG)717""",
    """PB9)XBT""",
    """KD6)CRR""",
    """3R1)2VM""",
    """7L2)WBG""",
    """LMV)K2V""",
    """TZR)QHW""",
    """G29)T6Y""",
    """J8T)MBW""",
    """75Y)ZD9""",
    """F5L)FZ9""",
    """P41)MWB""",
    """K3H)DM9""",
    """XHF)55Q""",
    """1SR)9K5""",
    """45Q)PHP""",
    """5V1)62L""",
    """ZQ7)M49""",
    """316)LJZ""",
    """T9X)22Z""",
    """9NM)2TX""",
    """7WY)NJ2""",
    """6P7)H94""",
    """TMM)ZT6""",
    """7NW)DSM""",
    """LHH)8GN""",
    """HGR)R8H""",
    """TRK)D2X""",
    """KSG)JLM""",
    """RMY)C24""",
    """NJ7)QXK""",
    """VYL)V3F""",
    """4M6)FVK""",
    """CRN)Q22""",
    """MXQ)8FW""",
    """NPZ)RY5""",
    """Q7Z)99J""",
    """51R)X6D""",
    """6DN)BQ4""",
    """KQC)HQY""",
    """ZM9)Z22""",
    """LNL)YL3""",
    """FZ8)GWG""",
    """B3C)75Y""",
    """4QY)TGC""",
    """12Y)HHV""",
    """7YL)P7N""",
    """12W)FM7""",
    """MGS)M5W""",
    """8F2)G7T""",
    """123)KRK""",
    """JMS)X4M""",
    """93Z)VGK""",
    """TJG)3FC""",
    """4WZ)82V""",
    """1FL)2XT""",
    """QGC)J9D""",
    """B6T)PFZ""",
    """6BB)LGH""",
    """39V)979""",
    """9B7)DB1""",
    """N22)5JX""",
    """GXW)PB9""",
    """XWH)C7H""",
    """K8W)4B3""",
    """HY5)CXG""",
    """NQS)LLT""",
    """5PL)49N""",
    """WGL)H9T""",
    """TLK)RMS""",
    """T9R)FQQ""",
    """TYZ)MD7""",
    """KVJ)HJJ""",
    """S44)LY9""",
    """8D6)1K2""",
    """61V)13N""",
    """T9C)BSH""",
    """RMS)L7W""",
    """82L)HS4""",
    """6XY)24H""",
    """Z9L)GMB""",
    """S3M)CW7""",
    """LYF)5YL""",
    """XGB)WG5""",
    """67Y)QYD""",
    """T9C)VYL""",
    """Z4V)SDL""",
    """B43)NF4""",
    """MHC)HLV""",
    """CMD)X4T""",
    """99J)Q7Y""",
    """LWT)ZLY""",
    """DNK)H7P""",
    """RB5)RWF""",
    """ZX8)X39""",
    """MD7)N3Y""",
    """T38)Q57""",
    """CCN)T2H""",
    """TRL)Q3L""",
    """36G)N52""",
    """7XP)1BR""",
    """4GQ)NQH""",
    """XGM)XJD""",
    """QJ1)Q1Q""",
    """SQT)1FC""",
    """JZ2)W82""",
    """6BM)HZB""",
    """KRK)5ZW""",
    """7F9)PSS""",
    """2CT)6S6""",
    """2S9)LWT""",
    """7RG)7NY""",
    """M4K)39V""",
    """Q7W)Z5S""",
    """HJW)M1P""",
    """7N7)7YK""",
    """MRD)PTX""",
    """49N)JTX""",
    """HKR)VCK""",
    """236)9PC""",
    """7VM)Y95""",
    """RY5)VTH""",
    """RWP)NTJ""",
    """RV4)6WN""",
    """N4H)4JP""",
    """TMP)YST""",
    """JLS)DYF""",
    """ZQG)HJW""",
    """K6H)12W""",
    """BW2)HCG""",
    """HBP)XMX""",
    """Q7C)DZ4""",
    """9D3)Y7M""",
    """J9K)7Z8""",
    """8C2)7YB""",
    """X3J)Z1N""",
    """FSF)Q3G""",
    """RLB)S49""",
    """Z6D)P59""",
    """ZNJ)LN5""",
    """25B)63C""",
    """G47)F8B""",
    """5DW)PFT""",
    """SD7)93Z""",
    """VK8)RDG""",
    """V5K)KNZ""",
    """BYV)XWH""",
    """NG9)1X2""",
    """46J)NV5""",
    """1L9)LPF""",
    """Q22)MHC""",
    """ZLD)FYT""",
    """ZRK)KQC""",
    """N5S)5F5""",
    """3JN)F39""",
    """CLH)DMF""",
    """B47)NZX""",
    """MKL)LYF""",
    """FZP)25J""",
    """SR3)SVS""",
    """ZDM)NN1""",
    """XPC)KG1""",
    """RWF)1N8""",
    """775)T38""",
    """VXW)8D6""",
    """V3F)6T1""",
    """JJY)HQD""",
    """FFH)HTN""",
    """F44)6D7""",
    """N34)7T5""",
    """B26)8GD""",
    """C6W)KSC""",
    """3YH)DNK""",
    """GF2)123""",
    """LRV)5WC""",
    """W99)JL3""",
    """FTJ)YCM""",
    """LC9)PXH""",
    """7RC)N34""",
    """8T3)L54""",
    """Z8T)GHP""",
    """1N6)6TS""",
    """2XW)GDQ""",
    """3LL)WLV""",
    """FHK)834""",
    """KG5)WVL""",
    """9NH)L3R""",
    """QYD)7TM""",
    """NQH)YSP""",
    """PS7)6NJ""",
    """V8J)2XG""",
    """PWX)774""",
    """Y1K)X4W""",
    """MGL)L55""",
    """V1M)ZPD""",
    """QNK)NCJ""",
    """KD6)QHP""",
    """MMX)B9W""",
    """YC3)ZV8""",
    """7SG)R8R""",
    """B43)GWF""",
    """3FC)Y3Z""",
    """PH3)8CH""",
    """PJX)DY3""",
    """TSF)W6P""",
    """YYR)785""",
    """VJZ)553""",
    """FYT)FSC""",
    """TPF)SLP""",
    """7WV)SR1""",
    """XGX)FV1""",
    """R3Q)8W4""",
    """Z1L)7L2""",
    """CF2)YKV""",
    """D2X)SBS""",
    """NN5)K1X""",
    """Q3G)7FN""",
    """Q24)XKR""",
    """KTP)JLK""",
    """C7K)HWS""",
    """ZXM)LV9""",
    """6M5)2XW""",
    """4D3)RSN""",
    """6NJ)7QM""",
    """8WM)D1C""",
    """6JW)Y8B""",
    """4ZT)Y3B""",
    """ZCN)C6W""",
    """H94)HDV""",
    """TH3)TSV""",
    """2M2)3B1""",
    """NF4)2WX""",
    """7BN)53G""",
    """JLS)HZY""",
    """Q4K)35Y""",
    """YCY)F8G""",
    """FTX)XL1""",
    """4F9)9NZ""",
    """HGZ)XYF""",
    """3CD)H7V""",
    """DX4)HW4""",
    """PFT)LZW""",
    """3GP)XSG""",
    """SVM)8WR""",
    """DJ9)GPD""",
    """HHK)BBW""",
    """RDG)FZ8""",
    """ZBB)79J""",
    """2BL)QSQ""",
    """1F6)9QF""",
    """442)N28""",
    """7GW)9G1""",
    """2J1)16J""",
    """NJ5)7DQ""",
    """MXL)G6D""",
    """BZZ)R3M""",
    """1TM)XGX""",
    """LGH)G1R""",
    """CQK)6GH""",
    """GZQ)VG8""",
    """QHP)G47""",
    """Z2P)DN2""",
    """Z42)N5Q""",
    """LT5)X9N""",
    """Q6J)967""",
    """G2J)113""",
    """W34)T9R""",
    """1DW)YJF""",
    """J1C)V34""",
    """KYZ)2WN""",
    """VLM)Q7Z""",
    """5MM)TRL""",
    """RNW)VT3""",
    """D33)75J""",
    """TSV)B4P""",
    """SVS)J4D""",
    """VMD)ZF8""",
    """2H5)Z8T""",
    """YH5)M53""",
    """VT3)NN5""",
    """76Y)6DN""",
    """Z5S)H2H""",
    """636)WGL""",
    """1BR)QNK""",
    """TTD)6SW""",
    """66H)Q1G""",
    """8RP)1P6""",
    """FQQ)K6H""",
    """MRD)LT5""",
    """2Z5)47T""",
    """YPG)2K7""",
    """FCK)SN1""",
    """7V2)KVJ""",
    """N22)KN3""",
    """D1W)DFB""",
    """X6D)S7L""",
    """Q1Q)6HG""",
    """QG2)FCK""",
    """PSS)CNP""",
    """HHH)WHL""",
    """VYN)FXV""",
    """C65)NPZ""",
    """VHW)SLQ""",
    """C1J)636""",
    """M13)QV1""",
    """J7V)KYZ""",
    """8GN)YN4""",
    """9DN)FR8""",
    """YST)Q63""",
    """L7W)QVP""",
    """553)9D3""",
    """C5G)BZ9""",
    """35Y)GSX""",
    """7YK)6LS""",
    """WJP)P8F""",
    """3CB)KBQ""",
    """P59)WFZ""",
    """NXF)V4Q""",
    """GM5)4FQ""",
    """RBL)QFX""",
    """LLT)G9Y""",
    """SM3)6K1""",
    """8KT)ZPJ""",
    """N9G)QD2""",
    """4B3)PKZ""",
    """Q7N)477""",
    """SGS)Y1Z""",
    """3PM)BBT""",
    """SGF)HPD""",
    """9LX)D6T""",
    """HLV)ZR6""",
    """QSV)TP6""",
    """8QY)7RP""",
    """LZR)YZW""",
    """D43)QVC""",
    """QSQ)VHT""",
    """NTF)JQ7""",
    """PX1)LWF""",
    """Y13)Q6J""",
    """JK6)XGZ""",
    """113)9MN""",
    """Y7M)7B4""",
    """6WN)TGJ""",
    """8FW)797""",
    """XKD)TD6""",
    """Q8V)B4L""",
    """LFJ)SM7""",
    """LVW)QT7""",
    """2SS)VV3""",
    """429)ZY7""",
    """ZDM)X67""",
    """S93)M4X""",
    """2GT)3MY""",
    """X94)WVG""",
    """H7P)18L""",
    """H8W)V8F""",
    """833)NTF""",
    """SN1)NC3""",
    """D75)K21""",
    """9TT)4ZT""",
    """KSJ)PRX""",
    """5WP)1Z4""",
    """2VM)Q67""",
    """WKY)5KD""",
    """1V9)62R""",
    """PPZ)HPM""",
    """7GH)HGZ""",
    """7B4)MSQ""",
    """6MB)HHN""",
    """SQT)SMN""",
    """QFX)NXF""",
    """GVY)HQV""",
    """H7V)465""",
    """J3F)853""",
    """2XH)BWW""",
    """HQY)32Y""",
    """Q8V)LZR""",
    """Z42)GQ8""",
    """HPD)7B1""",
    """GZC)VD2""",
    """BBT)XMM""",
    """FQQ)918""",
    """V34)97H""",
    """GJJ)JK6""",
    """C6W)ZBB""",
    """3ZX)Z19""",
    """HPP)VQB""",
    """VTH)8HL""",
    """1X2)RPW""",
    """J4L)22D""",
    """75V)NHS""",
    """XVH)HKR""",
    """PC7)7V4""",
    """CXV)G1S""",
    """2CC)ZQG""",
    """8FW)NGK""",
    """8FP)PZX""",
    """K4G)H6N""",
    """BTQ)MZZ""",
    """J32)6GJ""",
    """CRV)84K""",
    """J4T)4P7""",
    """35C)3JQ""",
    """T8C)Z1L""",
    """2XG)2HK""",
    """6D3)S7Q""",
    """SF5)7XP""",
    """WQT)T9N""",
    """H6N)GJJ""",
    """967)JLS""",
    """16M)W9Y""",
    """H4J)9CJ""",
    """C9B)C69""",
    """SBX)GR7""",
    """CNP)SCB""",
    """K2X)TSH""",
    """NMD)LNL""",
    """22D)TQV""",
    """5GN)3L1""",
    """C3Z)VJQ""",
    """XDD)54M""",
    """FXM)7FM""",
    """RC1)BZ1""",
    """FZ9)TH3""",
    """WYL)BYV""",
    """R5G)BQ3""",
    """LJF)V1M""",
    """PNX)HWC""",
    """CVS)F5L""",
    """FNW)7RC""",
    """SYB)SD1""",
    """Z19)LWW""",
    """KVT)1ZG""",
    """N41)LJF""",
    """SCB)TYZ""",
    """6TQ)75V""",
    """6GH)WKY""",
    """6SX)HHH""",
    """4M6)2J1""",
    """TCD)QG2""",
    """1WY)TG6""",
    """GBT)K3H""",
    """BZ9)CVM""",
    """WYH)LW8""",
    """VCK)YQL""",
    """PNX)4HG""",
    """J9D)FNW""",
    """RV4)QGC""",
    """3C7)ZBM""",
    """4MP)3GJ""",
    """6LS)GH7""",
    """8FR)FV8""",
    """DBF)6V7""",
    """C24)CT4""",
    """GWF)CBK""",
    """9G1)N5S""",
    """19J)RMG""",
    """75J)P41""",
    """2Q5)3GP""",
    """VQ5)VCC""",
    """2W3)TGX""",
    """G1S)2M2""",
    """318)TZ9""",
    """GP7)HJL""",
    """6TS)GPF""",
    """LWT)QJ1""",
    """LR8)PJN""",
    """SGS)YCY""",
    """D3F)CBN""",
    """QJ3)M5H""",
    """P33)L26""",
    """FY2)6DF""",
    """62R)ZLK""",
    """7QM)78K""",
    """3KZ)6NS""",
    """L26)69M""",
    """T8D)7YL""",
    """9P7)19J""",
    """DHC)JDC""",
    """S95)SBX""",
    """F5W)ZPR""",
    """HWS)H4G""",
    """BNW)W4T""",
    """7YL)KRX""",
    """YKV)D56""",
    """6NS)DT9""",
    """XSY)TTD""",
    """9QF)QZY""",
    """3L1)QCT""",
    """T5Q)ZJP""",
    """3KC)N39""",
    """RPY)CMD""",
    """T4W)G6H""",
    """7B1)NCZ""",
    """9K5)J55""",
    """Y1Z)2CN""",
    """WYH)FZW""",
    """QKS)3R1""",
    """3B1)3L5""",
    """L6S)HBP""",
    """D9W)XGD""",
    """G6H)CSX""",
    """FKR)2L2""",
    """XQ5)GBT""",
    """YZW)VBG""",
    """Q63)5X6""",
    """Z1N)GBS""",
    """5JX)VJ4""",
    """QF7)5GF""",
    """DQW)DJK""",
    """26L)1XD""",
    """1FC)93P""",
    """91D)RB5""",
    """RHJ)JZ2""",
    """ZD7)4B4""",
    """B2D)YK9""",
    """ZDP)GM5""",
    """QZY)6JW""",
    """WPF)ZXM""",
    """1DW)GZ2""",
    """RPW)WHS""",
    """YC3)9B7""",
    """7TG)QR7""",
    """67S)442""",
    """M5H)WB7""",
    """LWW)9KN""",
    """16M)J4L""",
    """2XC)GZC""",
    """ZF2)WR1""",
    """MMV)4GQ""",
    """L4Q)6SX""",
    """X4W)FZT""",
    """S7Q)J7V""",
    """NCZ)12Y""",
    """3GJ)PWX""",
    """961)Z42""",
    """F8G)FPC""",
    """99J)2GT""",
    """SFF)WPL""",
    """6SV)9SJ""",
    """97J)YY8""",
    """G1R)LXK""",
    """RF2)1GM""",
    """B54)LC2""",
    """8ZY)F44""",
    """4NX)H5Z""",
    """NC3)DZP""",
    """L6P)Z5J""",
    """DZP)M88""",
    """K2Q)FTX""",
    """7WV)VHN""",
    """KND)VJZ""",
    """B4P)M77""",
    """9RJ)GVY""",
    """7L7)316""",
    """9BV)RZM""",
    """29W)X5J""",
    """1ZG)4Q9""",
    """F9Y)6BM""",
    """MKY)T5B""",
    """D3T)GQY""",
    """6SV)3CD""",
    """XQG)J1C""",
    """24H)FKR""",
    """75Q)QYN""",
    """G3S)KCM""",
    """CYC)L6P""",
    """R2P)PPZ""",
    """1K2)C7K""",
    """7RP)3KZ""",
    """7GR)4Y9""",
    """ZYY)DQ2""",
    """G47)CXV""",
    """4TW)VMD""",
    """SBF)34L""",
    """N3H)SS5""",
    """LR8)CLH""",
    """HWC)5NM""",
    """ZY7)G58""",
    """39F)5K9""",
    """6T1)S5N""",
    """GHP)QQT""",
    """4BS)4D5""",
    """2TX)PYW""",
    """62L)1MT""",
    """JTX)X8S""",
    """HJJ)XHH""",
    """M3X)XKD""",
    """JQ7)Z6D""",
    """L3R)P7P""",
    """PFV)4QY""",
    """CYW)L4X""",
    """7FM)X2S""",
    """Q57)VLM""",
    """PVH)4XW""",
    """HL8)G1W""",
    """Y3B)8KT""",
    """4P7)ZCN""",
    """G2T)5YB""",
    """VL5)3W5""",
    """P8F)ZL1""",
    """48K)469""",
    """DFF)YLR""",
    """HHH)SD7""",
    """HKJ)C1J""",
    """5YL)GXG""",
    """3S1)SFF""",
    """HT1)3S1""",
    """RPL)F3D""",
    """8W4)FRD""",
    """KT6)CV3""",
    """YRC)65V""",
    """QSV)G2J""",
    """DV8)JZY""",
    """N7D)C1Y""",
    """ZZC)K46""",
    """TCY)ZRL""",
    """QT7)C5G""",
    """XG9)GZQ""",
    """HR4)PNX""",
    """NTF)6BB""",
    """G19)PZ6""",
    """PZ6)ZX8""",
    """WZG)C65""",
    """PC2)S29""",
    """WFZ)KVT""",
    """T5H)1WP""",
    """5KD)82L""",
    """12H)WVS""",
    """DSM)MKG""",
    """KSC)V8J""",
    """NX7)FFH""",
    """1VH)C9B""",
    """PNS)D1W""",
    """XPF)YYR""",
    """X8X)C8M""",
    """Z22)TRM""",
    """S5N)DBC""",
    """2WN)FTS""",
    """HLN)V24""",
    """J5K)VXW""",
    """DBF)S95""",
    """B4L)YC3""",
    """477)J1L""",
    """8CH)SF5""",
    """LJ3)YRC""",
    """XR5)Q6Z""",
    """GQ8)YR9""",
    """5GF)5ZT""",
    """QV1)4DZ""",
    """LYR)25B""",
    """M2H)V5K""",
    """V4X)YL8""",
    """M5C)1TM""",
    """YL8)ZH7""",
    """22Z)PVH""",
    """785)YOU""",
    """XRR)PFW""",
    """RFR)Y91""",
    """X7S)V4Y""",
    """TVD)VTT""",
    """Q3L)4P8""",
    """79J)LNM""",
    """BRX)NX7""",
    """RK8)9LX""",
    """2CN)N22""",
    """3VJ)W75""",
    """ZH7)KGG""",
    """XYF)TV6""",
    """X8S)N59""",
    """5WD)GF2""",
    """ZQW)F9Y""",
    """45V)4VF""",
    """BW3)9XG""",
    """7NQ)CZY""",
    """NPZ)BGC""",
    """5C4)B43""",
    """H1B)BRX""",
    """DYF)CTN""",
    """TGJ)LB7""",
    """M53)LFJ""",
    """853)4DC""",
    """5K9)J5B""",
    """T5Y)MTN""",
    """FR8)N41""",
    """M9F)8F2""",
    """4NR)X4K""",
    """HTM)833""",
    """NTJ)SQT""",
    """H7P)SZ4""",
    """KG1)75Q""",
    """DLY)TJ7""",
    """G3S)Z2P""",
    """G6D)2Z7""",
    """18L)9W4""",
    """QVC)ZYY""",
    """XQ5)39F""",
    """SLQ)HHK""",
    """KTQ)J8X""",
    """7Z8)1NV""",
    """9W3)G1T""",
    """YGQ)7G5""",
    """RP8)3TN""",
    """X9N)KX7""",
    """KWC)JMW""",
    """RF9)4HM""",
    """LNM)ZRK""",
    """1MT)88Y""",
    """MFF)8QY""",
    """63C)9LS""",
    """RH3)SMR""",
    """ZPK)5D2""",
    """SR1)C3Z""",
    """7C5)KWC""",
    """2WY)Y13""",
    """PJN)23L""",
    """CTN)9NM""",
    """9W4)SYB""",
    """KN3)2W3""",
    """QWX)FS8""",
    """5HG)6SP""",
    """JJX)WQT""",
    """QTT)JMS""",
    """3ZX)WMC""",
    """K1X)LC9""",
    """X7S)WJP""",
    """T5Q)NZZ""",
    """M2F)B2M""",
    """7NY)MGL""",
    """54M)8ZL""",
    """VD2)TTV""",
    """93P)9W3""",
    """LZR)DJQ""",
    """9B4)XDR""",
    """BXB)3YH""",
    """ZR6)SD4""",
    """FT8)3LL""",
    """GJV)9NH""",
    """84K)JQJ""",
    """JDC)YR2""",
    """JLK)16M""",
    """5NM)S44""",
    """3JQ)D9W""",
    """TGX)3ZX""",
    """LNL)5MM""",
    """L1V)ZRG""",
    """6R9)8C2""",
    """ZRL)68Y""",
    """X5J)ZRT""",
    """FV1)6HP""",
    """6K9)M7V""",
    """HPM)DM8""",
    """ZT6)HZR""",
    """BBW)SM6""",
    """GXG)PKR""",
    """ZLK)1F6""",
    """BSM)HPP""",
    """717)3TJ""",
    """VY6)CQD""",
    """VG7)961""",
    """1SR)7PP""",
    """LZD)3F1""",
    """Y8G)9J1""",
    """HHV)LMV""",
    """JCG)CYW""",
    """FM7)MFB""",
    """3V4)FNN""",
    """PGS)RPL""",
    """5VN)QSV""",
    """W82)2CC""",
    """FV8)MKY""",
    """BZS)XCP""",
    """21W)C11""",
    """V8Z)RBL""",
    """CFK)DKJ""",
    """7QV)Z9L""",
    """FSC)ZQ7""",
    """5NM)67S""",
    """98H)S8Z""",
    """C23)YH5""",
    """HQV)12H""",
    """V12)RWP""",
    """CBC)45Q""",
    """MKG)DJ9""",
    """2C3)CYC""",
    """BF9)2H5""",
    """MFB)MK3""",
    """YSP)BZS""",
    """VJQ)5XB""",
    """LWJ)1WF""",
    """27D)MRD""",
    """MN8)RB9""",
    """SS5)FT8""",
    """7TP)J32""",
    """2SS)4TC""",
    """Q67)QQ9""",
    """29D)9XB""",
    """1XD)K2X""",
    """774)HDK""",
    """N5Q)FL8""",
    """P18)X8X""",
    """4Q9)TZR""",
    """KC1)Y7V""",
    """FQX)VQ5""",
    """18B)ZP6""",
    """XVH)Q9D""",
    """6NJ)SM3""",
    """4WW)WYH""",
    """GWB)36G""",
    """BNW)YK4""",
    """3TL)K8W""",
    """CBK)236""",
    """XMM)PS7""",
    """25W)TCB""",
    """5WC)GP7""",
    """NFQ)2BL""",
    """5X6)Q4J""",
    """DM9)QTT""",
    """S76)TLK""",
    """HL6)7LR""",
    """VTT)D3F""",
    """D1C)D3D""",
    """518)18B""",
    """YCM)FML""",
    """6Y1)91D""",
    """YYR)M5C""",
    """P7P)C4S""",
    """5ZW)1VH""",
    """7LR)G3S""",
    """71F)V9B""",
    """62R)4S4""",
    """F9N)5V1""",
    """67Y)T4C""",
    """G9Y)MMB""",
    """FL8)6D3""",
    """K2P)2YR""",
    """XV4)9ZC""",
    """Y8B)ZPK""",
    """K21)W34""",
    """9LS)391""",
    """JGH)T4W""",
    """V24)T8D""",
    """GBS)HBV""",
    """D1K)SAN""",
    """6L1)Y1K""",
    """TWQ)TSF""",
    """LY9)H8W""",
    """JRC)F5W""",
    """N3Y)6PV""",
    """7BN)5WP""",
    """51W)P33""",
    """FCK)KJ5""",
    """M1P)4WZ""",
    """G3D)TC8""",
    """71R)2XF""",
    """9LX)D75""",
    """Q6Z)7VM""",
    """TRM)TTJ""",
    """HJT)ZD7""",
    """C5G)3C7""",
    """WB7)1FL""",
    """FRD)7WY""",
    """977)7C1""",
    """5LV)QH6""",
    """PM3)RH3""",
    """L4Y)B2D""",
    """5LB)TRK""",
    """BSH)XSY""",
    """913)QX3""",
    """T9N)WPF""",
    """HHN)XPF""",
    """495)M2H""",
    """7PP)3MX""",
    """TZ9)NYP""",
    """YR2)8YK""",
    """ZL2)F3B""",
    """4B4)48V""",
    """KQQ)FZP""",
    """CV3)26L""",
    """VHT)4KQ""",
    """HQS)2SS""",
    """4LN)JGH""",
    """48V)H77""",
    """H4J)KG5""",
    """2YR)ZYW""",
    """6T1)3GK""",
    """HS4)QKS""",
    """5JX)X3J""",
    """85Z)5VN""",
    """Z19)D43""",
    """JMW)495""",
    """FZT)V1L""",
    """SSP)HMR""",
    """GMB)T5Y""",
    """8YK)R5G""",
    """3W5)N7D""",
    """6K1)1TW""",
    """TKT)27D""",
    """GQY)J4T""",
    """TCD)NG9""",
    """TGC)LZD""",
    """82V)6Q8""",
    """J1L)237""",
    """KWC)98H""",
    """F39)2H7""",
    """MRT)G19""",
    """4FQ)29D""",
    """12Y)FY2""",
    """GDQ)B5J""",
    """ZPR)PDZ""",
    """FZW)149""",
    """6GJ)743""",
    """J8X)775""",
    """1TW)RMY""",
    """WR1)71R""",
    """QKS)4F9""",
    """YN4)BRY""",
    """JZY)51R""",
    """1N8)T9C""",
    """T9X)YV8""",
    """55Q)CGN""",
    """7QV)B47""",
    """3Q8)S76""",
    """LN5)CBC""",
    """W6P)HY5""",
    """WG5)P9L""",
    """4GF)7C5""",
    """XBT)913""",
    """CQD)T5Q""",
    """WBG)6DV""",
    """YV8)KC1""",
    """XHH)VK8""",
    """743)RF2""",
    """97H)XV4""",
    """TLD)HL6""",
    """MD5)HNR""",
    """HW4)WLN""",
    """S66)MDK""",
    """961)NJ5""",
    """SM6)HT1""",
    """MDT)Y6X""",
    """13N)9DN""",
    """X39)PCM""",
    """LXK)T5H""",
    """TQK)HP6""",
    """3GK)KMX""",
    """614)VZ7""",
    """6D3)3PM""",
    """TCB)QFN""",
    """VCC)2C3""",
    """WVS)7L7""",
    """8L4)LKQ""",
    """VF1)PX1""",
    """XGD)L4Y""",
    """2XH)GWL""",
    """1Z4)BSM""",
    """D6T)45V""",
    """7KG)PPK""",
    """CVM)1B1""",
    """WVL)GWB""",
    """NCJ)X7S""",
    """WPL)6Y1""",
    """NHS)S4F""",
    """LC2)4GF""",
    """GWL)F7N""",
    """DB1)T9X""",
    """D1W)HL8""",
    """192)LWJ""",
    """6DF)B54""",
    """FNN)DDT""",
    """3TJ)ZZC""",
    """S49)RK8""",
    """6GH)5DW""",
    """47T)SSP""",
    """LPF)SVM""",
    """V8Z)L4Q""",
    """2HK)XRR""",
    """RYD)977""",
    """C3N)BNW""",
    """M4X)Q4K""",
    """C3V)JNK""",
    """6W1)NL2""",
    """6H3)RLB""",
    """2XT)G1F""",
    """834)9YD""",
    """N28)X94""",
    """XL1)6XY""",
    """GZ2)TJG""",
    """DJQ)BXB""",
    """KX7)ZLD""",
    """VGK)N1S""",
    """W75)CRV""",
    """YK4)XR5""",
    """DJK)SQG""",
    """C7H)V8V""",
    """6SP)8RP""",
    """2Z7)BW3""",
    """QQ9)K4G""",
    """W34)M3X""",
    """P4X)MMX""",
    """KMX)NMD""",
    """5ZT)KSJ""",
    """9KN)S1L""",
    """PKR)KND""",
    """C69)RNW""",
    """8ZL)D1K""",
    """4WX)21W""",
    """QX3)BW2""",
    """HQD)3V4""",
    """M3C)G29""",
    """3RF)C23""",
    """ZF8)MD5""",
    """6D7)Q24""",
    """2YR)G3D""",
    """GPF)ZL2""",
    """BQ4)CRN""",
    """SLP)V4X""",
    """M7V)8FP""",
    """43X)5LV""",
    """8BV)7TP""",
    """L55)7BN""",
    """32Y)MGS""",
    """CRR)ZNJ""",
    """6HG)8SV""",
    """2WX)F9N""",
    """SD1)6K9""",
    """RRR)6TQ""",
    """K8W)B21""",
    """MMV)F4G""",
    """DM8)QT4""",
    """9MN)29C""",
    """WL2)35C""",
    """V1L)JRC""",
    """R3M)44K""",
    """K46)F54""",
    """23L)KT6""",
    """P7N)YB5""",
    """BWW)6W1""",
    """HZY)RFR""",
    """WLN)PGS""",
    """QD2)DCW""",
    """1NV)7NW""",
    """HP6)518""",
    """XCP)WCS""",
    """Q3V)ZF2""",
    """NJ2)2Q5""",
    """TD6)782""",
    """149)7TG""",
    """5D2)994""",
    """TP6)1L9""",
    """GN6)QYF""",
    """WVV)TX7""",
    """Y91)ZM9""",
    """YK9)6KG""",
    """QFN)BF9""",
    """W9Y)FSF""",
    """ZP6)3JN""",
    """M88)VY6""",
    """M45)8CF""",
    """DDT)8JC""",
    """C1Y)PC7""",
    """797)J8T""",
    """FPC)PBL""",
    """T6Y)MS1""",
    """YQL)B6T""",
    """PFZ)97J""",
    """HZY)TCY""",
    """NZX)SFM""",
    """SS5)2CT""",
    """WMC)M3C""",
    """W4T)48K""",
    """TJR)7GW""",
    """QHW)WKQ""",
    """8HL)QWX""",
    """5YB)VYN""",
    """S1Z)P7F""",
    """H8M)SBT""",
    """4D5)M2F""",
    """TC8)HQS""",
    """QR7)VBB""",
    """9J1)Q7C""",
    """V9B)88V""",
    """CBN)MN8""",
    """PYW)XQG""",
    """JRS)9P7""",
    """KTQ)J3F""",
    """J1K)PC2""",
    """VJ4)JJY""",
    """PFW)WH8""",
    """6XR)MXL""",
    """88Y)FJ8""",
    """2K7)GN6""",
    """GXW)JJ5""",
    """CGN)JRS""",
    """PKZ)CCN""",
    """X4M)S66""",
    """18B)RPY""",
    """78K)4BS""",
    """DN2)KSG""",
    """V4Q)CQK""",
    """QH6)YPG""",
    """2Z5)2KF"""
)