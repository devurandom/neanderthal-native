//   Copyright (c) Dragan Djuric. All rights reserved.
//   The use and distribution terms for this software are covered by the
//   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) or later
//   which can be found in the file LICENSE at the root of this distribution.
//   By using this software in any fashion, you are agreeing to be bound by
//   the terms of this license.
//   You must not remove this notice, or any other, from this software.

package uncomplicate.neanderthal;

import java.nio.Buffer;

public class CBLAS {

    public static final int ORDER_ROW_MAJOR = 101;
    public static final int ORDER_COLUMN_MAJOR = 102;
    public static final int TRANSPOSE_NO_TRANS = 111;
    public static final int TRANSPOSE_TRANS = 112;
    public static final int TRANSPOSE_CONJ_TRANS = 113;
    public static final int TRANSPOSE_ATLAS_CONJ = 114;
    public static final int UPLO_UPPER = 121;
    public static final int UPLO_LOWER = 122;
    public static final int DIAG_NON_UNIT = 131;
    public static final int DIAG_UNIT = 132;
    public static final int SIDE_LEFT = 141;
    public static final int SIDE_RIGHT = 142;

    static {
        NarSystem.loadLibrary();
    }

    /*
     * ======================================================
     * Level 1 BLAS functions
     * ======================================================
     */


    /*
     * ------------------------------------------------------
     * DOT
     * ------------------------------------------------------
     */

    public static native float sdsdot(int N, float alpha,
                                      Buffer X, int offsetX, int incX,
                                      Buffer Y, int offsetY, int incY);

    public static native double dsdot(int N,
                                      Buffer X, int offsetX, int incX,
                                      Buffer Y, int offsetY, int incY);

    public static native double ddot(int N,
                                     Buffer X, int offsetX, int incX,
                                     Buffer Y, int offsetY, int incY);

    public static native float sdot(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * NRM2
     * ------------------------------------------------------
     */

    public static native float snrm2(int N, Buffer X, int offsetX, int incX);

    public static native double dnrm2(int N, Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * ASUM
     * ------------------------------------------------------
     */

    public static native float sasum(int N, Buffer X, int offsetX, int incX);

    public static native double dasum(int N, Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * IAMAX
     * ------------------------------------------------------
     */

    public static native int isamax(int N, Buffer X, int offsetX, int incX);

    public static native int idamax(int N, Buffer X, int offsetX, int incX);

    /*
     * ======================================================
     * Level 1 BLAS procedures
     * ======================================================
     */

    /*
     * ------------------------------------------------------
     * ROT
     * ------------------------------------------------------
     */

    public static native void srot(int N,
                                   Buffer X, int offsetX, int incX,
                                   Buffer Y, int offsetY, int incY,
                                   float c, float s);

    public static native void drot(int N,
                                   Buffer X, int offsetX, int incX,
                                   Buffer Y, int offsetY, int incY,
                                   double c, double s);

    /*
     * ------------------------------------------------------
     * ROTG
     * ------------------------------------------------------
     */

    public static native void srotg(Buffer abcs, int offset_abcs, int inc_abcs);

    public static native void drotg(Buffer abcs, int offset_abcs, int inc_abcs);

    /*
     * ------------------------------------------------------
     * ROTM
     * ------------------------------------------------------
     */

    public static native void srotm(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY,
                                    Buffer param);

    public static native void drotm(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY,
                                    Buffer param);

    /*
     * ------------------------------------------------------
     * ROTMG
     * ------------------------------------------------------
     */

    public static native void srotmg(Buffer d1d2xy, int offset_d1d2xy, int inc_d1d2xy,
                                     Buffer param);

    public static native void drotmg(Buffer d1d2xy, int offset_d1d2xy, int inc_d1d2xy,
                                     Buffer param);

    /*
     * ------------------------------------------------------
     * SWAP
     * ------------------------------------------------------
     */

    public static native void sswap(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    public static native void dswap(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * SCAL
     * ------------------------------------------------------
     */

    public static native void sscal(int N, float alpha,
                                    Buffer X, int offsetX, int incX);

    public static native void dscal(int N, double alpha,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * SCOPY
     * ------------------------------------------------------
     */

    public static native void scopy(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    public static native void dcopy(int N,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * AXPY
     * ------------------------------------------------------
     */

    public static native void saxpy(int N, float alpha,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    public static native void daxpy(int N, double alpha,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ======================================================
     * Level 2 BLAS procedures
     * ======================================================
     */


    /*
     * ------------------------------------------------------
     * GEVM
     * ------------------------------------------------------
     */

    public static native void sgemv(int Order, int TransA,
                                    int M, int N,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    float beta,
                                    Buffer Y, int offsetY, int incY);

    public static native void dgemv(int Order, int TransA,
                                    int M, int N,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    double beta,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * GBMV
     * ------------------------------------------------------
     */

    public static native void sgbmv(int Order, int TransA,
                                    int M, int N,
                                    int KL, int KU,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    float beta,
                                    Buffer Y, int offsetY, int incY);


    public static native void dgbmv(int Order, int TransA,
                                    int M, int N,
                                    int KL, int KU,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    double beta,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * SYMV
     * ------------------------------------------------------
     */

    public static native void ssymv(int Order, int Uplo,
                                    int N,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    float beta,
                                    Buffer Y, int offsetY, int incY);

    public static native void dsymv(int Order, int Uplo,
                                    int N,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    double beta,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * SBMV
     * ------------------------------------------------------
     */

    public static native void ssbmv(int Order, int Uplo,
                                    int N, int K,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    float beta,
                                    Buffer Y, int offsetY, int incY);

    public static native void dsbmv(int Order, int Uplo,
                                    int N, int K,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX,
                                    double beta,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * SPMV
     * ------------------------------------------------------
     */

    public static native void sspmv(int Order, int Uplo,
                                    int N,
                                    float alpha,
                                    Buffer Ap,
                                    Buffer X, int offsetX, int incX,
                                    float beta,
                                    Buffer Y, int offsetY, int incY);

    public static native void dspmv(int Order, int Uplo,
                                    int N,
                                    double alpha,
                                    Buffer Ap,
                                    Buffer X, int offsetX, int incX,
                                    double beta,
                                    Buffer Y, int offsetY, int incY);

    /*
     * ------------------------------------------------------
     * TRMV
     * ------------------------------------------------------
     */

    public static native void strmv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    public static native void dtrmv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * TBMV
     * ------------------------------------------------------
     */

    public static native void stbmv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N, int K,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    public static native void dtbmv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N, int K,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * TPMV
     * ------------------------------------------------------
     */

    public static native void stpmv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer Ap,
                                    Buffer X, int offsetX, int incX);

    public static native void dtpmv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer Ap,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * TRSV
     * ------------------------------------------------------
     */

    public static native void strsv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    public static native void dtrsv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * TBSV
     * ------------------------------------------------------
     */

    public static native void stbsv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N, int K,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    public static native void dtbsv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N, int K,
                                    Buffer A, int offsetA, int lda,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * TPSV
     * ------------------------------------------------------
     */

    public static native void stpsv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer Ap,
                                    Buffer X, int offsetX, int incX);

    public static native void dtpsv(int Order, int Uplo,
                                    int TransA, int Diag,
                                    int N,
                                    Buffer Ap,
                                    Buffer X, int offsetX, int incX);

    /*
     * ------------------------------------------------------
     * GER
     * ------------------------------------------------------
     */

    public static native void sger(int Order,
                                   int M, int N,
                                   float alpha,
                                   Buffer X, int offsetX, int incX,
                                   Buffer Y, int offsetY, int incY,
                                   Buffer A, int offsetA, int lda);

    public static native void dger(int Order,
                                   int M, int N,
                                   double alpha,
                                   Buffer X, int offsetX, int incX,
                                   Buffer Y, int offsetY, int incY,
                                   Buffer A, int offsetA, int lda);

    /*
     * ------------------------------------------------------
     * SYR
     * ------------------------------------------------------
     */

    public static native void ssyr(int Order, int Uplo,
                                   int N,
                                   float alpha,
                                   Buffer X, int offsetX, int incX,
                                   Buffer A, int offsetA, int lda);

    public static native void dsyr(int Order, int Uplo,
                                   int N,
                                   double alpha,
                                   Buffer X, int offsetX, int incX,
                                   Buffer A, int offsetA, int lda);

    /*
     * ------------------------------------------------------
     * SPR
     * ------------------------------------------------------
     */

    public static native void sspr(int Order, int Uplo,
                                   int N,
                                   float alpha,
                                   Buffer X, int offsetX, int incX,
                                   Buffer Ap);

    public static native void dspr(int Order, int Uplo,
                                   int N,
                                   double alpha,
                                   Buffer X, int offsetX, int incX,
                                   Buffer Ap);

    /*
     * ------------------------------------------------------
     * SYR2
     * ------------------------------------------------------
     */

    public static native void ssyr2(int Order, int Uplo,
                                    int N,
                                    float alpha,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY,
                                    Buffer A, int offsetA, int lda);

    public static native void dsyr2(int Order, int Uplo,
                                    int N,
                                    double alpha,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY,
                                    Buffer A, int offsetA, int lda);

    /*
     * ------------------------------------------------------
     * SPR2
     * ------------------------------------------------------
     */

    public static native void sspr2(int Order, int Uplo,
                                    int N,
                                    float alpha,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY,
                                    Buffer Ap);

    public static native void dspr2(int Order, int Uplo,
                                    int N,
                                    double alpha,
                                    Buffer X, int offsetX, int incX,
                                    Buffer Y, int offsetY, int incY,
                                    Buffer Ap);

    /*
     * ======================================================
     * Level 3 BLAS procedures
     * ======================================================
     */


    /*
     * ------------------------------------------------------
     * GEMM
     * ------------------------------------------------------
     */

    public static native void sgemm(int Order, int TransA, int TransB,
                                    int M, int N, int K,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb,
                                    float beta,
                                    Buffer C, int offsetC, int ldc);

    public static native void dgemm(int Order, int TransA, int TransB,
                                    int M, int N, int K,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb,
                                    double beta,
                                    Buffer C, int offsetC, int ldc);

    /*
     * ------------------------------------------------------
     * SYMM
     * ------------------------------------------------------
     */

    public static native void ssymm(int Order, int Side, int Uplo,
                                    int M, int N,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb,
                                    float beta,
                                    Buffer C, int offsetC, int ldc);

    public static native void dsymm(int Order, int Side, int Uplo,
                                    int M, int N,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb,
                                    double beta,
                                    Buffer C, int offsetC, int ldc);

    /*
     * ------------------------------------------------------
     * SYRK
     * ------------------------------------------------------
     */

    public static native void ssyrk(int Order, int Uplo, int Trans,
                                    int N, int K,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    float beta,
                                    Buffer C, int offsetC, int ldc);

    public static native void dsyrk(int Order, int Uplo, int Trans,
                                    int N, int K,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    float beta,
                                    Buffer C, int offsetC, int ldc);

    /*
     * ------------------------------------------------------
     * SYR2K
     * ------------------------------------------------------
     */

    public static native void ssyr2k(int Order, int Uplo, int Trans,
                                    int N, int K,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb,
                                    float beta,
                                    Buffer C, int offsetC, int ldc);

    public static native void dsyr2k(int Order, int Uplo, int Trans,
                                     int N, int K,
                                     double alpha,
                                     Buffer A, int offsetA, int lda,
                                     Buffer B, int offsetB, int ldb,
                                     double beta,
                                     Buffer C, int offsetC, int ldc);

    /*
     * ------------------------------------------------------
     * TRMM
     * ------------------------------------------------------
     */

    public static native void strmm(int Order, int Side,
                                    int Uplo, int TransA, int Diag,
                                    int M, int N,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb);

    public static native void dtrmm(int Order, int Side,
                                    int Uplo, int TransA, int Diag,
                                    int M, int N,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb);

    /*
     * ------------------------------------------------------
     * TRSM
     * ------------------------------------------------------
     */

    public static native void strsm(int Order, int Side,
                                    int Uplo, int TransA, int Diag,
                                    int M, int N,
                                    float alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb);

    public static native void dtrsm(int Order, int Side,
                                    int Uplo, int TransA, int Diag,
                                    int M, int N,
                                    double alpha,
                                    Buffer A, int offsetA, int lda,
                                    Buffer B, int offsetB, int ldb);


    /*
     * ------------------------------------------------------
     * SUM
     * ------------------------------------------------------
     */

    public static native float ssum(int N, Buffer X, int offsetX, int incX);

    public static native double dsum(int N, Buffer X, int offsetX, int incX);

}
