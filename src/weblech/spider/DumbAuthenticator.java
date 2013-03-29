/*
 * This is the MIT license, see also http://www.opensource.org/licenses/mit-license.html
 *
 * Copyright (c) 2001 Brian Pitcher
 * Copyright (c) 2004 Andrew Coleman
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package weblech.spider;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import weblech.ui.LechLogger;

public class DumbAuthenticator extends Authenticator
{
    private final String user;
    private final String password;

    public DumbAuthenticator(String user, String password)
    {
        LechLogger.debug("DumbAuthenticator(" + user + ", ***)");
        this.user = user;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication()
    {
        LechLogger.debug("getPasswordAuthentication()");
        return new PasswordAuthentication(user, password.toCharArray());
    }
}