package com.shop.tomford.file.command.uploadFiles;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UploadFilesCommand implements IRequest<Collection<String>> {

    private MultipartFile[] files;
}
