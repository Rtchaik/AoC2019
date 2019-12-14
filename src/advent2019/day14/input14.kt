package advent2019.day14

const val oreLimit = 1000000000000

val input = listOf(
    """4 DGXQJ => 5 QNMV""",
    """10 WHSGM => 6 LFXWM""",
    """3 XRJH, 15 FVRFC, 19 DGXQJ, 2 BZWFZ, 8 XDQG, 1 LFXWM, 6 CDRP => 1 LWKJL""",
    """1 TLGRN => 5 BDPJD""",
    """1 DBGK, 5 DTWF => 3 FVRFC""",
    """7 NMWGH => 9 CGRFH""",
    """1 TLRZ => 2 XRJH""",
    """1 RGRHS => 7 WSGW""",
    """1 DGXQJ, 15 PWXFD, 9 XRJH => 4 LGVS""",
    """5 QHGP, 1 WHSGM => 7 DBGK""",
    """1 RHKVX => 5 CDRP""",
    """6 VMVJS => 5 VFVBP""",
    """1 WSGW => 6 PGBK""",
    """1 FXLD, 1 VMVJS => 8 PGJC""",
    """4 WCWLK => 1 KCHWM""",
    """11 XDQG => 2 QMVLD""",
    """137 ORE => 4 KRSK""",
    """4 KRSK => 5 HSCF""",
    """1 KRSK => 7 XPGP""",
    """4 BZWFZ, 1 TLGRN, 6 CTBV => 1 CPXLQ""",
    """9 WNVTR, 3 FVRFC, 6 CTBV => 2 RGRHS""",
    """5 KRSK => 3 JLSHT""",
    """4 DHJD => 2 DTWF""",
    """9 PGJC => 9 RNJCV""",
    """1 KCHWM, 10 DGXQJ => 4 PWXFD""",
    """6 KSJPW => 8 DHJD""",
    """6 DBGK, 1 ZPVDZ => 3 BJLQG""",
    """1 WNVTR, 2 XRJH => 9 ZPVDZ""",
    """3 DHJD => 8 KVKM""",
    """2 HSCF, 1 TLRZ => 9 QHGP""",
    """1 PLDS, 7 BJLQG, 1 WNVTR => 3 XDQG""",
    """14 CTBV, 23 PLDS, 5 MCNR => 9 TLGRN""",
    """1 PWXFD => 7 DJSW""",
    """2 DJSW => 6 MCNR""",
    """1 CTBV, 7 PGBK, 5 BDPJD, 5 DTWF, 12 PLDS, 31 RNJCV, 2 KVKM => 6 DJLXD""",
    """2 XRJH, 2 FXLD => 2 WHSGM""",
    """4 XPGP, 12 PWXFD => 9 FXLD""",
    """2 LGVS, 1 VMVJS, 1 QNMV => 3 HKXCV""",
    """1 WCWLK => 6 TLRZ""",
    """115 ORE => 7 TKMGN""",
    """2 TLGRN, 2 DHJD, 1 MCNR => 9 SCZCQ""",
    """13 FVRFC => 5 XBLQD""",
    """5 XDQG, 1 DZJLT => 4 CPGS""",
    """5 XPGP, 1 DHJD => 6 CTBV""",
    """1 XRJH, 2 KCHWM, 1 FXLD => 9 FSRD""",
    """5 CTBV, 1 CDRP, 5 RNJCV => 6 DZJLT""",
    """151 ORE => 6 WCWLK""",
    """4 HKXCV => 9 PLDS""",
    """16 KCHWM => 6 VKPGK""",
    """3 VKPGK => 1 HCMT""",
    """5 QMVLD, 8 HCMT, 25 CPXLQ, 29 JLSHT, 9 CPGS, 8 RHKVX, 19 DQTLW, 5 LWKJL, 2 DJLXD, 14 CVBQ, 7 SCZCQ, 17 FSRD, 3 JLHWQ, 6 XDQG => 1 FUEL""",
    """1 FXLD, 1 VMVJS => 8 NMWGH""",
    """2 KCHWM, 6 HSCF => 9 KSJPW""",
    """2 DBGK, 17 NMWGH => 1 JLHWQ""",
    """26 CDRP => 8 DQTLW""",
    """2 PLDS => 7 HPCR""",
    """6 LGVS, 21 DGXQJ => 4 RHKVX""",
    """6 VFVBP => 2 BZWFZ""",
    """2 XDQG, 3 BDPJD, 10 DJSW, 1 CGRFH, 3 HPCR, 2 RHKVX, 5 BZWFZ, 13 XBLQD => 7 CVBQ""",
    """8 TKMGN => 7 DGXQJ""",
    """1 JLSHT, 20 KSJPW => 7 VMVJS""",
    """16 DJSW, 1 PGJC, 4 FXLD => 8 WNVTR"""
)